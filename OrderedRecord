import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Scanner;

public class OrderedRecord {
    OrderedRecord genesisNode;
    private String user_password;

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    SecretKey secretKey;
    byte[] cipher_text;
    String decryptedText;


    public OrderedRecord() throws Exception {
        if (genesisNode == null) {

            System.out.println("Please create the password");
            Scanner input = new Scanner(System.in);
            String plainText = input.nextLine();
            user_password = plainText;
            secretKey = getSecretEncryptionKey();
            cipher_text = encryptText(plainText, secretKey);
        } else {
            while (true) {
                // Taking input of password from user and matching it with decrypted text
                System.out.println("Please enter the password");
                Scanner input = new Scanner(System.in);
                String plainText = input.nextLine();
                if (plainText.equals(decryptedText)) ;
                break;
            }

        }
    }

    private static class Node {
        private Date date;
        private Node rightchildnode;
        private Node leftchildnode;
        private int nodenumber;
        private String nodeid;
        private Data data;
        private int hashdata;

        public Node getRightchildnode() {
            return rightchildnode;
        }

        public void setRightchildnode(Node rightchildnode) {
            this.rightchildnode = rightchildnode;
        }

        public Node getLeftchildnode() {
            return leftchildnode;
        }

        public void setLeftchildnode(Node leftchildnode) {
            this.leftchildnode = leftchildnode;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public int getNodenumber() {
            return nodenumber;
        }

        public void setNodenumber(int nodenumber) {
            this.nodenumber = nodenumber;
        }

        public String getNodeid() {
            return nodeid;
        }

        public void setNodeid(String nodeid) {
            this.nodeid = nodeid;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public int getHashdata() {
            return hashdata;
        }

        public void setHashdata(int hashdata) {
            this.hashdata = hashdata;
        }
    }

    private class Data {
        private String ownerid;
        private float value;
        private String ownername;
        private String hash;

        public String getOwnerid() {
            return ownerid;
        }

        public void setOwnerid(String ownerid) {
            this.ownerid = ownerid;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }


    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    private void insert(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    private void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    private int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }
    private static SecretKey getSecretEncryptionKey() throws Exception {

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128);

        SecretKey secretKey = generator.generateKey();

        return secretKey;

    }




    private static byte[] encryptText(String plainText, SecretKey secKey) throws Exception {

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

        return byteCipherText;

    }


    private static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {


        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

        return new String(bytePlainText);

    }

    private static String bytesToHex(byte[] hash) {

        return DatatypeConverter.printHexBinary(hash);
    }


    public void addUserData(String ownerID,float value, String ownername) {
        Data data=new Data();
        data.setOwnerid(ownerID);
        data.setValue(value);
        data.setOwnername(ownername);
        if(genesisNode==null)
        {
           Node node=new Node();
           node.data=data;
           node.date=new Date();
           node.leftchildnode=null;
           node.rightchildnode=null;
           node.nodenumber++;
           //created the node id from RandomGenerator class
           node.nodeid=RandomIDGenerator.createId();
           node.hashdata=this.hashCode();
        }
        else
        {

        }
    }
}
