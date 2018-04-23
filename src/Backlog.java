

	

	import java.util.ArrayList;
	import java.util.LinkedList;

	
	public class Backlog {
	    private String projectName;
	    private String projectLength;
	    private IssueList issues;


	    public Backlog(String name, String projectLength) {
	        this.projectName = name;
	        this.projectLength = projectLength;
	        this.issues = new IssueList();
	    }

	    public boolean addIssue(String title, double points){
	        return this.issues.addIssue(new scrumIssue(title, points));
	    }


	    public boolean addToSprint(int issueNumber, LinkedList<scrumIssue>sprint){
	        scrumIssue checkedIssue = this.issues.findIssue(issueNumber);
	        if(checkedIssue != null){
	            sprint.add(checkedIssue);
	            return true;
	        }
	        System.out.println(issueNumber + " does not exist in the Backlog");
	        return false;
	    }

	    public boolean addToSprint(String title, LinkedList<scrumIssue> sprint){
	        scrumIssue checkedIssue = this.issues.findIssue(title);
	        if(checkedIssue != null){
	            sprint.add(checkedIssue);
	            return true;
	        }

	        System.out.println("The issue "+title+" is not in the backlog");
	        return false;

	    }


	//inner Class
	    private class IssueList {
	        private ArrayList<scrumIssue> issues;

	        public IssueList(){
	            this.issues = new ArrayList<scrumIssue>();
	        }

	        public boolean addIssue(scrumIssue issue){
	            if(issues.contains(issue)){
	                return false;
	            }

	            this.issues.add(issue);
	            return true;
	        }

	        private scrumIssue findIssue(String title){
	            for(scrumIssue checkedIssue: this.issues){
	                if(checkedIssue.getTitle().equalsIgnoreCase(title)){
	                return checkedIssue;

	                }
	            }

	            return null;
	        }

	        public scrumIssue findIssue(int issueNumber){
	            int index = issueNumber-1;
	            if((index>0)&&(index<issues.size())){
	                return issues.get(index);
	            }

	            return null;
	        }

	    }
	}


