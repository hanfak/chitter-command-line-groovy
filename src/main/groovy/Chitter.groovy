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
    this.activeUser = name
    this.usersSignedUp.push(name)
  }

  def logOut() {
    this.activeUser = null
  }
}
