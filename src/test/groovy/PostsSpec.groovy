import spock.lang.*

class PostsSpec extends Specification {
  def posts
  def spike

  def setup() {
    posts = new Posts()
    spike = new User('Spike')
  }

  def 'at start number of posts is 0'() {

    expect:
    posts.getListOfPosts().size() == 0
  }

  def 'Can add a post if logged in'() {
    when:
    posts.createPost('Hello this is my first post', spike)

    then:
    posts.getListOfPosts().size() == 1
    posts.getListOfPosts()[0].getMessage() == 'Hello this is my first post'
  }

  def 'Cannot add a post if no active user'() {
    when:
    def activeUser = null
    posts.createPost('Hello this is my first post', activeUser)

    then:
    posts.getListOfPosts().size() == 0
    def exception = thrown(OnlyLoggedInUsersCanPostException)
    exception.message == 'Post not made: User must be logged in first'
  }

  def 'Can view my posts'() {
    given:
    def leo = new User('Leo')

    when:
    posts.createPost('Hello this is my first post', spike)
    posts.createPost('Hello this is my second post', spike)
    posts.createPost('A random post not by Spike', leo)

    then:
    posts.findAllPostsByUser('Spike').size() == 2
    posts.findAllPostsByUser('Spike')[0].getMessage() == 'Hello this is my first post'
    posts.findAllPostsByUser('Spike')[1].getMessage() == 'Hello this is my second post'
    posts.findAllPostsByUser('Spike').find {it.getMessage() == 'A random post not by Spike'} == null
  }

  def 'view timeline of user'() {
    given:
    def leo = new User('Leo')
    def nikesh = new User('Nikesh')
    nikesh.addFollower(leo)

    when:
    posts.createPost('A random post not by Spike', leo)
    posts.createPost('Hello this is my first post', spike)
    posts.createPost('what post by nikesh', nikesh)

    def result = posts.findAUsersFollowersPosts(nikesh)

    then:
    result[0].getMessage() == 'A random post not by Spike'
    result[1].getMessage() == 'what post by nikesh'
    result.size() == 2
    result.find {it.getMessage() == 'Hello this is my first post'} == null
  }

}
