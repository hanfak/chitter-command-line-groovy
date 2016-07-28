class Post {
  private def message
  private def author

  def Post(message, user) {
    this.message = message
    this.author = user
  }

  def getMessage() {
    this.message
  }

  def getAuthor() {
    this.author
  }
}
