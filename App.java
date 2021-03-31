import java.util.Scanner;
public class App {
    public static App app = new App();
    // linear array ivars
    private int[] linearArray = new int[5];

    // stack ivars
    private int[] stack = new int[5];
    private int stackIndex = 0;

    // queue ivars
    private int[] queue = new int[5];
    private int front = -1, rear = -1;

    // linked list ivars
    private int[][] linkedList = new int[5][2];
    private int rootNode = -1, pointer = -1, listCounter = 0;

    public static void main(String[] args) throws Exception {
        String welcomeNote = "Welcome to CSC305 - Group 14. Please select from the menu below:\n";
        welcomeNote += "1. Array\n";
        welcomeNote += "2. Stack\n";
        welcomeNote += "3. Queue\n";
        welcomeNote += "4. Linked List\n";
        welcomeNote += "5. Tree\n";
        welcomeNote += "6. Searching\n";
        welcomeNote += "7. Sorting\n";
        welcomeNote += "8. End Program\n";
        
        app.menuOptionHandle(welcomeNote);

    }

    public void menuOptionHandle(String menu) {  
        Scanner s = new Scanner(System.in);     
        int menuOption;
        while(true) {
            System.out.println(menu);
            menuOption = s.nextInt(); 
            switch (menuOption) {
                case 1: // Array
                    Array();
                    break;
                case 2: // Stack
                    Stack();
                    break;
                case 3: // Queue
                    Queue();
                    break;
                case 4: // Linked list
                    LinkedList();
                    break;
                case 5: // Tree
                    System.out.println("Select option for Tree:\n1. Insert\n2. Delete\n3. Show Tree\n.4. Quit Tree");
                    break;
                case 6: // Searching
                    System.out.println("Select option for Searching:\n1. Insert\n2. Delete\n3. Show Searching\n.4. Quit Searching");
                    break;
                case 7: // Sorting
                    System.out.println("Select option for Sort:\n1. Insertion Sort\n2. Selection Sort\n3. Bubble Sort\n.4. Quit Sort");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
            if(menuOption == 8){
                System.out.println("Thanks for stopping by...");
                break;
            } 
        }
        s.close();
    }

    // START ARRAY STRUCTURE
    public void Array(){
        Scanner in = new Scanner(System.in);
        while(true){
            int option = 0;
            System.out.println("Select option for Array:\n1. Insert\n2. Delete\n3. Get Values\n4. Quit Array");
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter value to insert: ");
                    int value = in.nextInt();
                    System.out.println("Enter index for the value: ");
                    int insertIndex = in.nextInt();
                    if(insertIntoArray(value, insertIndex)) {
                        System.out.println("Value inserted.");
                    } else {
                        System.out.println("Value not inserted");
                    }
                    break;
                case 2:
                    System.out.println("Enter index to delete: ");
                    int deleteIndex = in.nextInt();
                    if(deleteFromArray(deleteIndex)){
                        System.out.println("Value at index " + deleteIndex + " has been deleted");
                    }
                    break;
                case 3:
                    System.out.println(getLinearArray());
                    break;
                case 4:
                    break;
                default:
                    break;
            }
            if(option == 4) break;
        }
        in.close();
    }

    public boolean insertIntoArray(int value, int index){
        if(index < 0 || index > 4) return false;
        if(linearArray[index] != 0) return false;
        linearArray[index] = value;
        return true;
    }

    public boolean deleteFromArray(int index) {
        if(index < 0 || index > 4) return false;
        linearArray[index] = 0;
        return true;
    }
    
    public String getLinearArray(){
        return linearArray.toString();
    }

    // END ARRAY STRUCTURE

    // START STACK STRUCTURE

    public void Stack(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Select option for Stack:\n1. Push\n2. Pop\n3. Get Values\n4. Quit Stack");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter value to push onto stack: ");
                    int value = in.nextInt();
                    if(push(value)) {
                        System.out.println(value + " has been pushed to stack");
                    } else {
                        System.out.println(value + " could not be pushed");
                    }
                    break;
                case 2:
                    int popped = pop();
                    if(popped != 0) {
                        System.out.println(popped + " popped from stack");
                    }
                    break;
                case 3:
                    System.out.println(getStackValues());
                    break;
                default:
                    break;
            }
            if(option == 4) break;
        }
        in.close();
    }

    public boolean push(int value){
        if(app.stackIndex > 4) { // check if stack is full
            System.out.println("Stack overflow!");
            return false;
        }
        // insert value at current index
        app.stack[app.stackIndex] = value;
        // increment index value
        app.stackIndex++;
        return true;
    }

    public int pop(){
        if(app.stackIndex < 0) { // check if stack is empty
            System.out.println("Stack underflow!");
            return 0;
        }
        // get popped out value
        int popped = app.stack[app.stackIndex];
        // remove value at index
        app.stack[app.stackIndex] = 0;
        // decrement index value
        app.stackIndex--;
        return popped;
    }

    public String getStackValues(){
        return stack.toString();
    }

    // END STACK STRUCTURE

    // START QUEUE STRUCTURE

    public void Queue(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Select option for Queue:\n1. Enqueue\n2. Dequeue\n3. Get Values\n.4. Quit Queue");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter value to enqueue: ");
                    int value = in.nextInt();
                    if(enqueue(value)){
                        System.out.println(value + " enqueued at the rear");
                    } else {
                        System.out.println("Operation unsuccessful");
                    }
                    break;
                case 2:
                    if(dequeue()){
                        System.out.println("Value has been dequeued");
                    }
                case 3:
                    System.out.println(getQueueValues());
                default:
                    System.out.println("Invalid option");
                    break;
            }
            if(option == 4) break;
        }
        in.close();
    }

    public boolean enqueue(int value){
        // check if queue is full
        if((rear == queue.length - 1 && front == 0) || front == rear - 1){
            System.out.println("Queue is full");
            return false;
        } else if(front == -1){ // if value is the first to enqueue
            // initialize front and rear
            front = 0;
            rear = 0;
            // set value at rear
            queue[rear] = value;
        } if(rear == queue.length - 1 && front != 0){ // check if rear has reached end of circular queue
            rear = 0; // change rear to 0
            queue[rear] = value;
        } else {
            rear++; // increase value of rear
            queue[rear] = value;
        }
        return true;
    }

    public boolean dequeue(){
        // check if queue is empty using front
        if(front == -1){
            System.out.println("Queue is empty");
            return false;
        }
        // remove value at front of queue
        queue[front] = 0;
        // change value of front
        if(front == rear){ // when front and rear are equal
            front = -1;
            rear = -1;
        } else if(front == queue.length - 1){ // when front is at the end of the queue
            front = 0;
        } else { // increase the value of front
            front++;
        }
        return true;
    }

    public String getQueueValues(){
        return queue.toString();
    }

    // END QUEUE STRUCTURE

    // START LINKED LIST

    public void LinkedList(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Select option for Linked list:\n1. Insert\n2. Delete\n3. Get\n4. Quit Linked List");
            int option = in.nextInt();
            int value, index = -1, next = 0;
            switch (option) {
                case 1:
                    if(listCounter == 4) {
                        System.out.println("List is full");
                        break;
                    }
                    System.out.println("Enter value for node: ");
                    value = in.nextInt();
                    
                    // check if root node has been set
                    if(rootNode == -1){
                        System.out.println("Enter index for node: ");
                        index = in.nextInt();
                    }

                    if(listCounter < 4){
                        System.out.println("Enter next index for list: ");
                        next = in.nextInt();
                    } else {
                        System.out.println("This is last index, next index will be set to -1");
                    }

                    if(insertNode(value, index, next)){
                        System.out.println(value + " inserted at index " + index + ", next index is " + next);
                    } else {
                        System.out.println("Operation unsuccessful");
                    }
                    break;
                case 2:
                    System.out.println("Enter node index to delete: ");
                    int nodeToDelete = in.nextInt();
                    if(deleteNode(nodeToDelete)){
                        System.out.println("Node has been deleted");
                    }
                case 3:
                    getLinkedListValues();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            if(option == 4) break;
        }
        in.close();
    }

    public boolean insertNode(int value, int index, int next){
        if(next < 0 || next > 4) return false;
        if(index != -1 && rootNode == -1){
            rootNode = index; // set starting index to root node
            linkedList[index][0] = value;
            linkedList[index][1] = next;
        } else {
            linkedList[pointer][0] = value;
            linkedList[pointer][1] = listCounter == 4 ? -1 : next;
        }
        pointer = listCounter == 4 ? -1 : next; // set pointer for next index
        listCounter++; // increment list counter by 1
        return true;
    }

    public boolean deleteNode(int index) {
        if(index < 0 || index > 4) return false;
        for(int i = 0; i < linkedList.length; i++){
            if(linkedList[i][1] == index){
                linkedList[i][1] = linkedList[index][1];
                linkedList[index][0] = 0;
                linkedList[index][1] = 0;
            }
        }
        listCounter--; // decrement list counter by 1
        return true;
    }

    public void getLinkedListValues(){
        for(int i = 0; i < linkedList.length; i++){
            System.out.println(linkedList[i][0] + " - " + linkedList[i][1]);
        }
    }

    // END LINKED LIST

    // START TREE

    public void Tree(){
        
    }

    // END TREE

}
