

import java.util.*;

public class Main {

    private static ArrayList<Backlog> backlogs = new ArrayList<Backlog>();
	private static Scanner scanner;

    public static void main(String[] args) {

        Backlog backlog = new Backlog("Search Project", "2");
        backlog.addIssue("Code the user interface", 5);
        backlog.addIssue("Code the middle tier", 10);
        backlog.addIssue("Test the middle tier", 27);
        backlog.addIssue("Add error logging", 46);


        backlogs.add(backlog);

        LinkedList<scrumIssue> sprintBacklog = new LinkedList<scrumIssue>();
        backlogs.get(0).addToSprint(3 , sprintBacklog);
        backlogs.get(0).addToSprint("deal with error code", sprintBacklog);

        startSprint(sprintBacklog);

    }

    private static void startSprint(LinkedList<scrumIssue>sprint){
        scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<scrumIssue> listIterator = sprint.listIterator();
        if(sprint.size()==0){
            System.out.println("Please add stories to your backlog");
            return;
        }else{
            System.out.println("Now working on"+listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Log out of the scrum tool");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Now working on "+listIterator.next());
                    }else{
                        System.out.println("We have reached the end of the sprint backlog");
                        forward = false;
                    }

                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }

                        forward = false;

                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("Now back to working on "+listIterator.previous());
                    }else{
                        System.out.println("We are at the start of the backlog list");
                        forward = true;
                    }
                    break;

                case 3:
                    printSprintBacklog(sprint);
                    break;

                case 4:
                    printMenu();
                    break;

                case 5:
                    if(sprint.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Working on "+listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Back to working on "+listIterator.previous());
                        }
                    }

                    break;

            }
        }

    }


    private static void printMenu(){
        System.out.println("ScrumAsCode actions: \npress" +
                "0 : to quit \n" +
                "1 : to work on next item\n" +
                "2 : to work on previous item \n" +
                "3 : to review the sprint backlog \n" +
                "4 : to go back to the menu \n" +
                "5 : to remove a story from the sprint backlog");
    }

    private static void printSprintBacklog(LinkedList<scrumIssue> sprint){
        Iterator<scrumIssue> iterator = sprint.iterator();
        System.out.println("____________________________________________________________________________________________");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("____________________________________________________________________________________________");

    }

}
