class Chitter {
  private def activeUser
  private def usersSignedUp

  def Chitter(){
    activeUser = null
    usersSignedUp = []
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

  private def findUser(name) {
    this.usersSignedUp.find { it == name}
  }

  private def loginUser(name) {
    this.activeUser = name

    if(!findUser(name)) {
      this.usersSignedUp.push(name)
    }
  }

  private def logOutUser() {
    this.activeUser = null
  }
}
