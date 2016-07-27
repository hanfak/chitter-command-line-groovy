class Chitter {
  private def usersSignedUp
  private def posts

  def Chitter(users = new Users(), posts = new Posts()) {
    this.usersSignedUp = users
    this.posts = posts
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
    this.posts.createPost(message, getActiveUser())
  }

  def viewPosts() {
    this.posts.getListOfPosts()
  }

  def viewUserPosts(userName = getActiveUser().getName()) {
    this.posts.findAllPostsByUser(userName)
  }

  def follow(name) {
    this.getUsersSignedUp().followAUser(name)
  }

  def viewTimeline(userName = getActiveUser().getName()) {
    def theUser = getUsersSignedUp().getListofUsers().find {it.getName() == userName}
    this.posts.findAUsersFollowersPosts(theUser)
  }
}
