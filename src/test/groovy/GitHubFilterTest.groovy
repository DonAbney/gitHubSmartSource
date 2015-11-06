import spock.lang.Specification

class GitHubFilterTest extends Specification{

    def "location search returns list"() {
        setup:
	def gitHubAPI = Mock(GitHubAPI)
        GitHubFilter gitHubFilter = new GitHubFilter(gitHubAPI)
        when:
        def result = gitHubFilter.locationSearch('anyLocationString')
        then:
        result instanceof ArrayList
    }

    def "when a search is initiated the API is invoked with the search criteria"() {
        setup:
	def gitHubAPI = Mock(GitHubAPI)
        GitHubFilter gitHubFilter = new GitHubFilter(gitHubAPI)
	gitHubAPI.search('anyLocationString') >> {[]}
        when:
        def result = gitHubFilter.locationSearch('anyLocationString')
        then:
        1 * gitHubAPI.search('anyLocationString')
    }

}
