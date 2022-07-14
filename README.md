I use TWO fragments called Home and Details.
Initially load home fragments and check the internet connection. if the internet is available then call the API otherwise
data load from Room Database.
https://api.github.com/search/repositories?q=Android&sort=stargazers
When api data load then this data store in the room database for offline use.
Using MVVM pattern you can found this code structure in the code also use coroutine for API call
