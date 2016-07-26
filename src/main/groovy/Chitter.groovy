class Chitter {
  private def usersSignedUp
  private def posts
  private def postKlass

  def Chitter(users = new Users(), Class postClass = Post){
    this.usersSignedUp = users
    this.posts = []
    this.postKlass = postClass
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
    createPost(message)
  }

  def viewPosts() {
    this.posts
  }

  def viewUserPosts(userName = getActiveUser().getName()) {
    def theUser = getUsersSignedUp().getListofUsers().find {it.getName() == userName}
    this.viewPosts().findAll {it['user'] == theUser}
  }

  private def createPost(message) {
    def aPost = postKlass.newInstance(message)

    if(this.getActiveUser() == null) {
      throw new OnlyLoggedInUsersCanPostException('Post not made: User must be logged in first')
    } else {
      this.posts.push(['post' : aPost, 'user' : this.getActiveUser()])
    }
  }
}

class OnlyLoggedInUsersCanPostException extends Exception {
  OnlyLoggedInUsersCanPostException(String message) {
    super(message)
  }
}
