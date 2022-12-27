import java.util.Scanner;
class SMInf{
  private String name;
  private int hp;
  private int x;
  private int y;

  SMInf(String name, int hp, int x, int y){
    this.name = name;
    this.hp = hp;
    this.x = x;
    this.y = y;
  }

  public void setName(String s){
    name = s;
  }
  public void setHP(int n){
    hp = n;
  }
  public void setX(int n){
    x = n;
  }
  public void setY(int n){
    y = n;
  }

  public String getName(){
    return name;
  }
  public int getHP(){
    return hp;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }

  @Override
  public String toString(){
    return "Name: " + name + ", HP: " + hp + ", place = (" + x + ", " + y + ")\n";
  }
}


class SubMarine{
  static double[][] us = new int[7][7];//0or1
  static double[][] searchUs = new double[7][7];
  static double[][] enemy = new double[7][7];
  static int ourNum = 4;
  static int enemyLife = 12
  static int enemyNum = 4;
  static String enemyAction;

  public void makeBoard(){
    fill(us); fill(enemy); fill(searchUs);
  }
  public void fill(double[][] d){
    for(int i = 0; i < d.length(); i++){
      for(int j = 0; j < d[i].length(); j++){
        if(i == 0 || j == 0 || i == d.length()-1 || j == d[i].length()-1){
          final d[i][j] = -1;
        }
        else{
          d[i][j] = 0;
        }
      }
    }
  }


  public static void main(String[] args){
    Scanner sc = new Scanner();
    SMInf sub1 = new SMInf("sub1", 3, 1, 1);
    SMInf sub2 = new SMInf("sub2", 3, 2, 2);
    SMInf sub3 = new SMInf("sub3", 3, 3, 3);
    SMInf sub4 = new SMInf("sub4", 3, 4, 4);

    //zizenn syori
    Scanner sc = new Scanner(System.in);

    while(ourNum > 0 && enemyLife > 0){//loop
      enemyAction();
      ourAction();

      if(enemyLife <= 0){//end 1
        put("We Win!!!\n");
        return;
      }
      if(ourNum <= 0){//end2
        put("We lose.\n");
        return ;
      }
    }


  }
  public String weMove(int x, int y, String s){//zahyou to fune no namae

  }

  public void enemyAction(){

    put("enemy's action: ")
    string es = sc.nextString();
    if(es = "move"){
      String eDirection = sc.nextString();
      int moveNum = sc.nextInt();

      enemyMove(eDirection, moveNum);

    }
    if(es = "attack"){
      int ex = -1;
      do{
        put("fill x and y.\n");
        char ea = sc.nextChar();
        int ey = sc.nextInt();
        ex = transCtoI(ea);
      }while(ea > 0;)

      response(ex, ey);
    }

  }

  public void response(int x. int y){//*****
    judge(x, y);
    //syuuhenn masu atai hennkou
  }
  public void judge(int x, int y){//*****
    //hanntei
  }

  public int transCtoI(char ch){
    if(ch == 'a'){return 1;}
    if(ch == 'b'){return 2;}
    if(ch == 'c'){return 3;}
    if(ch == 'd'){return 4;}
    if(ch == 'e'){return 5;}
    else return -1;
  }
  public void put(String s){
    System.out.print(s);
  }

  public void enemyMove(String sdir, int num){
    if(sdir == "north"){
      for(int i = 1; i < 6 - num; i++){
        for(int j = 1; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "south"){
      for(int i = 1 + num; i < 6; i++){
        for(int j = 1; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "east"){
      for(int i = 1; i < 6; i++){
        for(int j = 1 + num; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "west"){
      for(int i = 1; i < 6; i++){
        for(int j = 1; j < 6 - num; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
  }



}
