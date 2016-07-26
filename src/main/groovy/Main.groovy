class Main {
  static main(String[] args) {
    //User Story 3
    def chitter = new Chitter()

    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')

    chitter.logOut()

    chitter.login('Leo')
    chitter.addPost('Othrepoer ')

    chitter.logOut()

    println('view all posts')
    println(chitter.viewPosts())

    println('View Leo posts')
    chitter.viewUserPosts('Leo')
    chitter.viewUserPosts('Leo').each {println(it['post'].getMessage())}

    println('View Spike posts')
    chitter.viewUserPosts('Spike')
    chitter.viewUserPosts('Spike').each {println(it['post'].getMessage())}


    // User story 2
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
    //
    // chitter.login('Spike')
    // println(chitter.viewPosts())
    //
    // println('Spike posts')
    // chitter.viewUserPosts().each {println(it['post'].getMessage())}

    //USer story 1
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
