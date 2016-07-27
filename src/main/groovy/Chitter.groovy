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
    this.createPost(message)
  }

  def viewPosts() {
    this.posts
  }

  def viewUserPosts(userName = getActiveUser().getName()) {
    this.findAllPostsByUser(userName)
  }

  def follow(name) {
    this.getUsersSignedUp().followAUser(name)
  }

  def viewTimeline(userName   = getActiveUser().getName() ) {
    this.findAUsersFollowersPosts(userName)
  }

  //Private methods
  private def findAllPostsByUser(userName) {
    def theUser = getUsersSignedUp().getListofUsers().find {it.getName() == userName}
    this.viewPosts().findAll {it['user'] == theUser}
  }

  private def findAUsersFollowersPosts(userName) {
    def theUser = getUsersSignedUp().getListofUsers().find {it.getName() == userName}
    def userTimeLinePosts = []
    this.viewPosts().each { post ->
      theUser.getFollowers().each { follower ->
        if(post['user'].getName() == follower.getName()) {
          userTimeLinePosts.push(post)
        }
      }
    }
    userTimeLinePosts
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
