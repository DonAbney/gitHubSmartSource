import spock.lang.Specification

class GitHubFilterTest extends Specification{

    GitHubFilter gitHubFilter
    def gitHubAPI

    def setup() {
	gitHubAPI = Mock(GitHubAPI)
        gitHubFilter = new GitHubFilter(gitHubAPI)
    }

    def "location search returns list"() {
        setup:
	gitHubAPI.search(_) >> {[]}
        when:
        def result = gitHubFilter.locationSearch('anyLocationString')
        then:
        result instanceof ArrayList
    }

    def "when a search is initiated the API is invoked with the search criteria"() {
        setup:
	gitHubAPI.search('anyLocationString') >> {[]}
        when:
        def result = gitHubFilter.locationSearch('anyLocationString')
        then:
        1 * gitHubAPI.search('anyLocationString')
    }

}
