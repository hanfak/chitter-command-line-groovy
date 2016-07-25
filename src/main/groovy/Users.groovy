class Users {
  private def activeUser
  private def listOfUsers
  private def userKlass

  def Users(Class userClass = User) {
    activeUser = null
    listOfUsers = []
    userKlass = userClass
  }

  def getLoggedInUser() {
    this.activeUser
  }

  def getListofUsers() {
    this.listOfUsers
  }

  def login(name) {
    def aUser = userKlass.newInstance(name)

    if(findUser(aUser)) {
      this.activeUser = findUser(aUser)
    } else {
      this.activeUser = aUser
      this.listOfUsers.push(aUser)
    }
  }

  def logOut() {
    this.activeUser = null
  }

  private def findUser(user) {
    this.listOfUsers.find { it.getName() == user.getName()}
  }
}
