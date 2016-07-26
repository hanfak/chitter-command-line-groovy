class Main {
  static main(String[] args) {
    //User Story 4
    println()
    println('----User Story 4 ----')

    def chitter = new Chitter()

    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')
    println("spike " + chitter.getActiveUser())
    chitter.logOut()

    chitter.login('Leo')
    chitter.addPost('Other post ')
    println("leo " + chitter.getActiveUser())
    chitter.logOut()

    chitter.login('Nikesh')
    chitter.addPost('what post by nikesh')
    println("nikesh " + chitter.getActiveUser())
    chitter.logOut()

    chitter.login('Spike')
    println(chitter.follow('Leo'))

    println(chitter.getActiveUser().getFollowers())
    chitter.follow('Nikesh')
    println(chitter.getActiveUser().getFollowers())

    chitter.viewUserPosts()


    //User Story 3
    // println()
    // println('----User Story 3 ----')
    //
    // def chitter = new Chitter()
    //
    // chitter.login('Spike')
    // chitter.addPost('Hello this is my first post')
    // chitter.addPost('Hello this is my second post')
    //
    // chitter.logOut()
    //
    // chitter.login('Leo')
    // chitter.addPost('Other post ')
    //
    // chitter.logOut()
    //
    // println('view all posts')
    // println(chitter.viewPosts())
    //
    // println('View Leo posts')
    // println(chitter.viewUserPosts('Leo'))
    // chitter.viewUserPosts('Leo').each {println(it['post'].getMessage())}
    //
    // println('View Spike posts')
    // println(chitter.viewUserPosts('Spike'))
    // chitter.viewUserPosts('Spike').each {println(it['post'].getMessage())}
    // println()

    // User story 2
    // println('----User Story 2 ----')
    // def chitter = new Chitter()
    //
    // chitter.login('Spike')
    //
    // println(chitter.viewPosts())
    //
    // chitter.addPost('Hello this is my first post')
    // chitter.addPost('Hello this is my second post')
    // println(chitter.viewPosts())
    //
    // println('Spike posts')
    // chitter.viewUserPosts().each {println(it['post'].getMessage())}
    //
    // chitter.logOut()
    //
    // chitter.login('Leo')
    // chitter.addPost('Other post')
    // println(chitter.viewPosts())
    //
    // println('Leo posts')
    // chitter.viewUserPosts().each {println(it['post'].getMessage())}
    //
    // chitter.logOut()
    // println()


    //USer story 1
    //println('----User Story 1 ----')
    // def chitter = new Chitter()
    // println(chitter.getActiveUser())
    // println(chitter.getUsersSignedUp().getListofUsers())
    // chitter.login('Spike')
    // println('active '  + chitter.getActiveUser())
    // println('active name '  + chitter.getActiveUser().getName())
    // println('users ' + chitter.getUsersSignedUp())
    // println('users ' + chitter.getUsersSignedUp().getListofUsers())
    // chitter.logOut()
    // println(chitter.getActiveUser())
    // // println('active name '  + chitter.getActiveUser().getName())
    // println(chitter.getUsersSignedUp())
    // println('users ' + chitter.getUsersSignedUp().getListofUsers())
    // chitter.login('Leo')
    // println(chitter.getActiveUser())
    // println('active name '  + chitter.getActiveUser().getName())
    // println(chitter.getUsersSignedUp())
    // println('users ' + chitter.getUsersSignedUp().getListofUsers())
    // chitter.logOut()
    // chitter.login('Spike')
    // println(chitter.getActiveUser())
    // println('active name '  + chitter.getActiveUser().getName())
    // println(chitter.getUsersSignedUp())
    // println('users ' + chitter.getUsersSignedUp().getListofUsers())
  }
}
