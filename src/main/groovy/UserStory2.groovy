class UserStory2 {
  static main(String[] args) {
    //User story 2
    println('----User Story 2 ----')
    def chitter = new Chitter()

    chitter.login('Spike')

    // println(chitter.viewPosts())
    println("add a post 'chitter.addPost('Hello this is my first post')''")
    chitter.addPost('Hello this is my first post')
    println('view posts added')
    println(chitter.viewPosts())
    println()

    println("add a post 'chitter.addPost('Hello this is my second post')''")
    chitter.addPost('Hello this is my second post')
    println('view posts added')
    println(chitter.viewPosts())
    println()

    println('Spike posts')
    chitter.viewUserPosts().each {println(it['post'].getMessage())}
  }
}
