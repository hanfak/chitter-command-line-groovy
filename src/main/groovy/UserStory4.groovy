class UserStory4 {
  static main(String[] args) {

    println('----User Story 4 ----')

    def chitter = new Chitter()
    println()
    println("Spike add a post: 'Hello this is my first post'")
    println("Spike add a post: 'Hello this is my second post'")
    println()
    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')
    chitter.logOut()

    println("Leo add a post: 'Other post '")
    chitter.login('Leo')
    chitter.addPost('Other post ')
    chitter.logOut()

    chitter.login('Nikesh')
    chitter.addPost('what post by nikesh')
    println("Nikesh add a post: 'what post by nikesh'")
    println('Nikesh follows Leo')
    chitter.follow('Leo')
    chitter.logOut()
    println()

    chitter.login('Spike')
    println('Spike follows Leo')

    println(chitter.follow('Leo'))
    println(chitter.viewUserPosts())
    println(chitter.getActiveUser().getFollowers())
    println()
    println('Spike follows Nikesh')

    chitter.follow('Nikesh')
    println(chitter.getActiveUser().getFollowers())
    println(chitter.getActiveUser())

    println()
    println('Spikes timelne' + chitter.viewTimeline())
    chitter.viewTimeline().each {println(it['post'].getMessage()+ ' by ' +  it['user'].getName())}
    println()

    println('Nikesh timelne' + chitter.viewTimeline('Nikesh'))
    chitter.viewTimeline('Nikesh').each {println(it['post'].getMessage() + ' by ' +  it['user'].getName())}
    println()


  }
}
