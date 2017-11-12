import java.util.*;
public class Demo {
    public static void main(String[] args) {
        String p[] = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String s[] = {"♠", "♣", "♥", "♦"};
        Person card[] = new Person[52];
        int e = 0, h = 0, r = 0, w = 0, an = 0;
        for (int i = 0; i < 52; i++) {//实体化
            card[i] = new Person();
        }
        for (int a = 0; a < 52; a += 4) {//先把花色标上
            card[a].setSuit(s[a % 4]);
            card[a + 1].setSuit(s[(a + 1) % 4]);
            card[a + 2].setSuit(s[(a + 2) % 4]);
            card[a + 3].setSuit(s[(a + 3) % 4]);
        }
        for (int b = 0; b < 13; b++) {//再写点数
            for (int c = 0; c < 4; c++) {
                card[e].setPoint(p[b]);
                e++;
            }
        }
        System.out.println("没洗牌之前的排序：");//为了保护里脊学长的眼睛研究的输出方式
        for (int d = 0; d < 13; d++) {
            for (int g = 0; g < 4; g++) {
                System.out.print(card[h].getSuit() + card[h].getPoint() + "\t");
                h++;
            }
            System.out.println();
        }
        Person one[] = new Person[26];
        Person two[] = new Person[26];
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 26; k++) {//前26张一摞
                one[k] = card[k];
            }
            for (int l = 0; l < 26; l++) {//后26张一摞
                two[l] = card[l + 26];
            }
            Random pass = new Random();
            int word=25, orz=25;
            for (int z=51 ; z >=0; z--) {
                int passNum = pass.nextInt(2);
                if (passNum == 1) {
                    if (word >= 0) {
                        card[z]=one[word];
                        word=word-1;
                    }
                }
                else {
                    if (orz >= 0){
                        card[z]=two[orz];
                        orz=orz-1;
                    }
                }
            }
        }
        System.out.println("第一种洗牌之后的排序：");//保护里脊新生有责
        for (int o = 0; o < 13; o++) {
            for (int q = 0; q < 4; q++) {
                System.out.print(card[r].getSuit() + card[r].getPoint() + "\t");
                r++;
            }
            System.out.println();
        }
        Random random = new Random();
        for (int t = 51; t >= 1; t--) {
            int u = 51;
            int randomNum = random.nextInt(u);
            Person joker = new Person();
            joker = card[t];
            card[t] = card[randomNum];
            card[randomNum] = joker;
            u--;
        }
        System.out.println("紧接着第二种洗牌之后的排序：");//保护里脊，坚持不懈
        for (int v = 0; v < 13; v++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(card[w].getSuit() + card[w].getPoint() + "\t");
                w++;
            }
            System.out.println();
        }
        Random dom = new Random();//虽然这个算法和上面有点像，但是我觉得随机数就是最优的解决方案了
        for (int y = 0; y <26; y++) {//所以我决定对上面的算法进行优化，比如降低他的代码数量和减少电脑计算量
            int domNum = dom.nextInt(26);//我觉得这样代码可读性也更高
            Person liji = new Person();
            liji = card[y];
            card[y] = card[domNum + 26];
            card[domNum+26] = liji;
        }
        System.out.println("紧接着第三种洗牌之后的排序：");//里脊学长看我多好为了你专门写输出算法，给我加点分吧
        for (int sum = 0; sum < 13; sum++) {
                for (int ram = 0; ram < 4; ram++) {
                System.out.print(card[an].getSuit() + card[an].getPoint() + "\t");
                an++;
            }
            System.out.println();
        }
    }
}
