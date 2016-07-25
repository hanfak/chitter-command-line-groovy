class Main {
  static main(String[] args) {
    def chitter = new Chitter()
    println(chitter.getActiveUser())
    println(chitter.getUsersSignedUp())
    chitter.login('Spike')
    println(chitter.getActiveUser())
    println(chitter.getUsersSignedUp())
    chitter.logOut()
    println(chitter.getActiveUser())
    println(chitter.getUsersSignedUp())
    chitter.login('Leo')
    println(chitter.getActiveUser())
    println(chitter.getUsersSignedUp())
    chitter.logOut()
    chitter.login('Spike')
    println(chitter.getActiveUser())
    println(chitter.getUsersSignedUp())
  }
}
