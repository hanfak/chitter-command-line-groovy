class Posts {
  def listOfPosts
  private def postKlass

  def Posts( Class postClass = Post) {
    this.listOfPosts = []
    this.postKlass = postClass
  }

  def getListOfPosts() {
    this.listOfPosts
  }

  def createPost(message, user) {
    def aPost = postKlass.newInstance(message)

    if(user == null) {
      throw new OnlyLoggedInUsersCanPostException('Post not made: User must be logged in first')
    } else {
      this.listOfPosts.push(['post' : aPost, 'user' : user])
    }
  }

  def findAllPostsByUser(userName) {
    this.getListOfPosts().findAll {it['user'].getName() == userName}
  }

  def findAUsersFollowersPosts(user) {
    def userTimeLinePosts = []
    this.getListOfPosts().each { post ->
      user.getFollowers().each { follower ->
        if(post['user'].getName() == follower.getName()) {
          userTimeLinePosts.push(post)
        }
      }
    }
    userTimeLinePosts
  }
}

class OnlyLoggedInUsersCanPostException extends Exception {
  OnlyLoggedInUsersCanPostException(String message) {
    super(message)
  }
}
