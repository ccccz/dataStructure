package main.java.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GList {

    public static void main(String[] args) {
        GList a=new GList();
        a.dfs(a);
    }

    HashMap<Integer,GNode> list=new HashMap<>();
    ArrayList<ArrayList<GNode>> rings=new ArrayList<>();

    public GList(){
//        Scanner scanner=new Scanner(System.in);
        String temp;
        GNode begin=null,end=null;
        File file=new File("E://edges.txt");
        try {
            FileReader fr=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fr);
            while((temp=bufferedReader.readLine())!=null){
                if (temp.equals("q")){
                    break;
                }
                int[] edge=new int[2];
                String[] ts=temp.split(",");
                edge[0]=Integer.parseInt(ts[0]);
                edge[1]=Integer.parseInt(ts[1]);
                if (list.containsKey(edge[0])){
                    begin=list.get(edge[0]);
                }else{
                    begin=new GNode(edge[0]);
                    list.put(edge[0],begin);
                }
                if (list.containsKey(edge[1])){
                    end=list.get(edge[1]);
                }else{
                    end=new GNode(edge[1]);
                    list.put(edge[1],end);
                }
                begin.getNextNode().add(end);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        start=begin.getLabel();
    }

    public void dfs(GList list){

        ArrayList<GNode> ring=new ArrayList<>();
        for (GNode root:list.list.values()){
            if (root.visit==0){
                GNode node=null;
                for (int j=0; j<root.getNextNode().size(); j++){
                    node=root.getNextNode().get(j);
                    ring.clear();
                    ring.add(root);
                    root.visit=1;
                    if (node==root){
                        continue;
                    }else{
                        ring.add(node);
                        node.visit=1;
                        dfs(node,ring);
                        ring.remove(node);
                    }
                }
            }
        }
        if (rings.size()==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
            System.out.println("---------------");
            System.out.println(rings.size());
            for (int j=0;j<rings.size(); j++){
                ArrayList<GNode> temp=rings.get(j);
                for (int k=0; k<temp.size()-1;k++){
                    System.out.print(temp.get(k).getLabel()+"->");
                }
                System.out.println(temp.get(temp.size()-1).getLabel());
            }
        }
    }

    private void dfs(GNode node,ArrayList<GNode> ring){
        GNode root=node;
//        node=root.nextNode;
        for (int j=0; j<root.getNextNode().size(); j++){
            node=root.getNextNode().get(j);
            if (node==root){
                continue;
            }else{
                if (ring.contains(node)){
                    torings(ring,node);
                }else{
                    ring.add(node);
                    node.visit=1;
                    dfs(node,ring);
                    ring.remove(node);
                }
//                node=node.nextNode;
            }
        }
    }

    private void torings(ArrayList<GNode> ring,GNode node){
        int i=0;
        ArrayList<GNode> temp=new ArrayList<>();
        for (; i<ring.size(); i++){
            if (ring.get(i).getLabel()==node.getLabel()){
                break;
            }
        }
        for (; i<ring.size(); i++){
            temp.add(ring.get(i));
        }
        for (int j=0; j<rings.size(); j++){
            boolean iscont=true;
            if (rings.get(j).size()==temp.size()){
                for (int k=0; k<temp.size(); k++){
                    if (!rings.get(j).contains(temp.get(k))){
                        iscont=false;
                        break;
                    }
                }
            }else{
                iscont=false;
            }
            if (iscont){
                return;
            }
        }
        rings.add(temp);
    }

}
