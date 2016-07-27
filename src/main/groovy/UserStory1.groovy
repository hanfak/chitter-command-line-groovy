class UserStory1 {
  static main(String[] args) {
    //User story 1
    println()
    println('----User Story 1 ----')
    def chitter = new Chitter()
    println("login Spike for first time 'chitter.login('Spike')'")
    chitter.login('Spike')
    println()
    println('active user is '  + chitter.getActiveUser().getName())
    println('active user object is ' + chitter.getActiveUser())
    println()

    println("log out Spike for first time 'chitter.logOut()'")
    chitter.logOut()
    println()
    println('active user is ' + chitter.getActiveUser())
    println('list of users ' + chitter.getUsersSignedUp().getListofUsers())
    println()
    println("login Leo for first time 'chitter.login('Leo')'")
    chitter.login('Leo')
    println('active user is ' + chitter.getActiveUser().getName())
    println('active user object is ' + chitter.getActiveUser())
    chitter.logOut()
    println()
    println('list of users ' + chitter.getUsersSignedUp().getListofUsers())
  }
}
