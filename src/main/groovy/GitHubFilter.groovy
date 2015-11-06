import GitHubAPI

class GitHubFilter {
    GitHubAPI gitHubApi    

    def GitHubFilter(api) {
        gitHubApi = api
    }

    def locationSearch(searchCriteria) {
        gitHubApi.search(searchCriteria)
        []

    }
}
