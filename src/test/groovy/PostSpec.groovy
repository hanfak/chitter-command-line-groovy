import spock.lang.*

class PostSpec extends Specification {
  def 'Post object has a message'() {
    given:
    def post = new Post('Hello, this is my first message')

    expect:
    post.getMessage() == 'Hello, this is my first message'
  }
}
