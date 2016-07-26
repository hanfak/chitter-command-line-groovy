class Chitter {
  private def usersSignedUp
  private def posts

  def Chitter(users = new Users()){
    this.usersSignedUp = users
    this.posts = []
  }

  def getActiveUser(){
    this.usersSignedUp.getLoggedInUser()
  }

  def getUsersSignedUp(){
    this.usersSignedUp
  }

  def login(name) {
    this.usersSignedUp.loginUser(name)
  }

  def logOut() {
    this.usersSignedUp.logOutUser()
  }

  def addPost(message) {
    if(this.getActiveUser() == null) {
      throw new OnlyLoggedInUsersCanPostException('Post not made: User must be logged in first')
    } else {
      this.posts.push(message)
    }
  }

  def viewPosts() {
    this.posts
  }
}

class OnlyLoggedInUsersCanPostException extends Exception {
  OnlyLoggedInUsersCanPostException(String message) {
    super(message)
  }
}
