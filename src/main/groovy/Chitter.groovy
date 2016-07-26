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
    findAUsersPosts(userName)
  }

  def follow(name) {
    addUserToFollowers(name)
  }

  private def addUserToFollowers(name) {
    def userToFollow = this.getUsersSignedUp().lookForUser(name)
    if(!userToFollow) {
      throw new UserDoesNotExistException('User not follower: User must exist first')
    }
    getActiveUser().addFollower(userToFollow)
  }

  private def findAUsersPosts(userName) {
    if(getActiveUser() && userName == getActiveUser().getName()) {
      def userTimeLinePosts = []
      this.viewPosts().each { post ->
        this.getActiveUser().getFollowers().each { follower ->
          if(post['user'].getName() == follower.getName()) {
            userTimeLinePosts.push(post)
          }
        }
      }
      userTimeLinePosts
    } else {
      def theUser = getUsersSignedUp().getListofUsers().find {it.getName() == userName}
      this.viewPosts().findAll {it['user'] == theUser}
    }
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

class UserDoesNotExistException extends Exception {
  UserDoesNotExistException(String message) {
    super(message)
  }
}
