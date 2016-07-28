import spock.lang.*

class PostSpec extends Specification {
  def 'Post object has a message'() {
    given:
    def spike = new User('Spike')
    def post = new Post('Hello, this is my first message', spike)

    expect:
    post.getMessage() == 'Hello, this is my first message'
    post.getAuthor().getName() == 'Spike'
  }
}
