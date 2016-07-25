class Chitter {
  private def activeUser
  private def usersSignedUp
  private def userKlass

  def Chitter(Class userClass = User){
    activeUser = null
    usersSignedUp = []
    userKlass = userClass
  }

  def getActiveUser(){
    this.activeUser
  }

  def getUsersSignedUp(){
    this.usersSignedUp
  }

  def login(name) {
    loginUser(name)
  }

  def logOut() {
    logOutUser()
  }

  private def findUser(user) {
    this.usersSignedUp.find { it.getName() == user.getName()}
  }

  private def loginUser(name) {
    def aUser = userKlass.newInstance(name)

    if(findUser(aUser)) {
      this.activeUser = findUser(aUser)
    } else {
      this.activeUser = aUser
      this.usersSignedUp.push(aUser)
    }
  }

  private def logOutUser() {
    this.activeUser = null
  }
}
