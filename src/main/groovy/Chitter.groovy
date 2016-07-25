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
}
