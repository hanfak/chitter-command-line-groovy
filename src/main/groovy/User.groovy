class User {
  def name
  def followers

  def User(name) {
    this.name = name
    this.followers = []
  }

  def getName() {
    this.name
  }

  def getFollowers() {
    this.followers
  }

  def addFollower(user) {
    this.followers.push(user)
  }
}
