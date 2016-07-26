class Chitter {
  private def usersSignedUp

  def Chitter(users = new Users()){
    this.usersSignedUp = users
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
}
