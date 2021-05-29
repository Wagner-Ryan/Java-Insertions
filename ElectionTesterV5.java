

/**
 * Ryan Wagner
 * 2/27/2021
 * Insert data in arrays
 */
public class ElectionTesterV5
{
    public static void main(String[] args){
        
        Candidate[] candidates = new Candidate[5];
        
        candidates[0] = new Candidate("Tony Stark", 3000);
        candidates[1] = new Candidate("Steve Rogers", 99);
        candidates[2] = new Candidate("Thor Odinson", 1500);
        candidates[3] = new Candidate("Bruce Banner", 1000);
        candidates[4] = new Candidate("Clint Barton", 48);
        
        System.out.printf("%18s", "Original Results");
        printResults(candidates);
        //method to insert a new candidate in a certain position
        addCandidate(candidates, 2, "God of Thunder", 15000);
        //method to find candidate by name and insert a new candidate before the candidate
        findAndInsert(candidates, "Steve Rogers", "Peter Quill", 50);
    }
    
    public static void printResults(Candidate[] candidates){
        int totalVotes = 0;
        for(Candidate c: candidates){
            totalVotes += c.getVotes();
        }
        System.out.printf("\n %30s %20s", "Votes", "% of Total");
        System.out.printf("\n %9s %22s %15s", "Candidate", "Recieved", "Votes");
        System.out.println("\n" + "====================================================");
        for(Candidate c: candidates){
            System.out.printf("%s %20s %17s \n", c.getName(), c.getVotes(), percentOfVotes(totalVotes, c.getVotes()));
        }
        //System.out.printf("%s %20s %17s \n", candidates[0].getName(), candidates[0].getVotes(), percentOfVotes(totalVotes, candidates[0].getVotes()));
        //System.out.printf("%s %18s %17s \n", candidates[1].getName(), candidates[1].getVotes(), percentOfVotes(totalVotes, candidates[1].getVotes()));
        //System.out.printf("%s %18s %17s \n", candidates[2].getName(), candidates[2].getVotes(), percentOfVotes(totalVotes, candidates[2].getVotes()));
        //System.out.printf("%s %18s %17s \n", candidates[3].getName(), candidates[3].getVotes(), percentOfVotes(totalVotes, candidates[3].getVotes()));
        //System.out.printf("%s %18s %17s \n", candidates[4].getName(), candidates[4].getVotes(), percentOfVotes(totalVotes, candidates[4].getVotes()));
        System.out.println("\nThe total number of votes is: " + totalVotes);
    }
    
    public static double percentOfVotes(int totalVotes, int votes){
        double tVotes = totalVotes, v = votes;
        double percentOfVotes = Math.round((v / tVotes) * 1000) / 10.0;
        return percentOfVotes;
    }
    
    public static void changeName(Candidate[] candidates, String name, String newName){
        for(Candidate c: candidates){
            if(c.getName().equals(name)){
                c.setName(newName);
                System.out.println("<< Changing " + name + " to " + newName + " >>");
            }
        }
        printResults(candidates);
    }
    
    public static void changeVotes(Candidate[] candidates, String name, int votes){
        for(Candidate c: candidates){
            if(c.getName().equals(name)){
                c.setVotes(votes);
                System.out.println("<< Changing " + name + "'s votes to " + votes + " >>");
            }
        }
        printResults(candidates);
    }
    
    public static void changeNameAndVotes(Candidate[] candidates, String name, String newName, int votes){
        for(Candidate c: candidates){
            if(c.getName().equals(name)){
                c.setName(newName);
                c.setVotes(votes);
            }
        }
        printResults(candidates);
    }
    
    public static void addCandidate(Candidate[] candidates, int position, String name, int votes){
        for(int i = candidates.length - 1; i > position; i--){
            candidates[i] = candidates[i-1];
        }
        candidates[position] = (new Candidate(name, votes));
        System.out.println("\n<<In position " + position + ", add " + name + ", " + votes + " votes>>");
        printResults(candidates);
    }
    
    public static void findAndInsert(Candidate[] candidates, String name2Find, String newName, int votes){
        int index = 0;
        for(int i = 0; i < candidates.length - 1; i++){
            if(candidates[i].getName().equals(name2Find)){
                index = i;
            }
        }
        for(int i = candidates.length - 1; i > index; i--){
            candidates[i] = candidates[i-1];
        }
        candidates[index] = (new Candidate(newName, votes));
        System.out.println("\nBefore " + name2Find + ", add " + newName + ", " + votes + " votes>>");
        printResults(candidates);
    }
}
