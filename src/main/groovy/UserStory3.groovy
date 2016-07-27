class UserStory3 {
  static main(String[] args) {
    // User Story 3
    println()
    println('----User Story 3 ----')

    def chitter = new Chitter()

    chitter.login('Spike')
    println('Add post from Spike')
    chitter.addPost('Hello this is my first post')
    println('Add post from Spike')
    chitter.addPost('Hello this is my second post')

    chitter.logOut()
    println()

    chitter.login('Leo')
    println('Add post from Leo')

    chitter.addPost('Other post ')

    chitter.logOut()

    println()
    println('view all posts')
    println(chitter.viewPosts())
    println()

    println('View Leo posts')
    println(chitter.viewUserPosts('Leo'))
    chitter.viewUserPosts('Leo').each {println(it['post'].getMessage())}
    println()
    println('View Spike posts')
    println(chitter.viewUserPosts('Spike'))
    chitter.viewUserPosts('Spike').each {println(it['post'].getMessage())}
    println()

  }
}
