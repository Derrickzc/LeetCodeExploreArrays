import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class Des {
    private int[] IP={58,50,42,34,26,18,10,2,
            60,52,44,36,28,20,12,4,
            62,54,46,38,30,22,14,6,
            64,56,48,40,32,24,16,8,
            57,49,41,33,25,17,9,1,
            59,51,43,35,27,19,11,3,
            61,53,45,37,29,21,13,5,
            63,55,47,39,31,23,15,7};

    //逆初始置换
    private int[] IP_1={40,8,48,16,56,24,64,32,
            39,7,47,15,55,23,63,31,
            38,6,46,14,54,22,62,30,
            37,5,45,13,53,21,61,29,
            36,4,44,12,52,20,60,28,
            35,3,43,11,51,19,59,27,
            34,2,42,10,50,18,58,26,
            33,1,41,9,49,17,57,25};

    //E扩展
    private int[] E={32,1,2,3,4,5,
            4,5,6,7,8,9,
            8,9,10,11,12,13,
            12,13,14,15,16,17,
            16,17,18,19,20,21,
            20,21,22,23,24,25,
            24,25,26,27,28,29,
            28,29,30,31,32,1};
    //P置换
    private int[] P={16,7,20,21,29,12,28,17,
            1,15,23,26,5,18,31,10,
            2,8,24,14,32,27,3,9,
            19,13,30,6,22,11,4,25};
    private static final int[][][] S_Box = {
            {
                    { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                    { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                    { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
            {
                    { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
                    { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                    { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                    { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
            {
                    { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                    { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                    { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                    { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
            {
                    { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                    { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                    { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                    { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
            {
                    { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                    { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                    { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                    { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
            {
                    { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                    { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                    { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                    { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
            {
                    { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                    { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                    { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                    { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
            {
                    { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                    { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                    { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                    { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } }
    };
    //PC-1
    private int[] PC1={57,49,41,33,25,17,9,
            1,58,50,42,34,26,18,
            10,2,59,51,43,35,27,
            19,11,3,60,52,44,36,
            63,55,47,39,31,23,15,
            7,62,54,46,38,30,22,
            14,6,61,53,45,37,29,
            21,13,5,28,20,12,4};
    //PC-2
    private int[] PC2={14,17,11,24,1,5,3,28,
            15,6,21,10,23,19,12,4,
            26,8,16,7,27,20,13,2,
            41,52,31,37,47,55,30,40,
            51,45,33,48,44,49,39,56,
            34,53,46,42,50,36,29,32};


    private int[] LFT={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    //Key循环左移次数要求
    /**加密轮数**/
    private int origin_length;
    /**16个子密钥**/
    private int[][] sub_key=new int[16][48];
    private String content;
    private int p_origin_length;

    public Des(String key,String content){
        this.content=content;
        p_origin_length=content.getBytes().length;
        generateKeys(key);
    }
    public static void main(String[] args){
        //origin 是需要加密的值
        String origin="01";
        System.out.println("原文：\n"+origin);

        Des customDES=new Des("5",origin);
        //在调用 构造函数的时候，就已经生成了16轮的key 存于sub_key[16][48]

        byte[] c=customDES.deal(origin.getBytes(),1);
        System.out.println("密文：\n"+new String(c));

        byte[]p=customDES.deal(c,0);
        byte[] p_d=new byte[origin.getBytes().length];
        System.arraycopy(p,0,p_d,0,origin.getBytes().length);
        System.out.println("明文：\n"+new String(p));

    }
    /***代码运行结果：
     *
     原文：
     Android将军->GeneralAndroid->主博客地址：https://blog.csdn.net/android_jiangjun
     密文：
     ��Lm����=��� 4�zf4�����zj���}���~Dͪn�B��t���Du��U*e�VxC�̃Ynh\@NH ˙P�Ka�1y~4
     明文：
     Android将军->GeneralAndroid->主博客地址：https://blog.csdn.net/android_jiangjun
     *
     * **/


    /****拆分分组****/
    //p 是明文消息String.getBytes() 也就是个 byte 数组
    //flag 是用来判断是加密还是解密的标志
    public byte[] deal(byte[] p ,int flag){

        origin_length=p.length;

        int g_num;
        int r_num;

        g_num=origin_length/8;
        r_num=8-(origin_length-g_num*8);
        //8不填充
        //除数 & 也不算是 余数 因为他用8-了
        //r_num 其实就相当于是 用来 计算需要 填补多少

        byte[] p_padding;

        /****填充********/
        // 如果 r_num<8 的话，就需要填充；

        if (r_num<8){
            p_padding=new byte[origin_length+r_num];
            System.arraycopy(p,0,p_padding,0,origin_length);
            for(int i=0;i<r_num;i++){
                p_padding[origin_length+i]=(byte)r_num;
            }

        }else{
            p_padding=p;
        }


        //
        g_num=p_padding.length/8;
        // 填补完后计算总长；也是表示加密次数


        byte[] f_p=new byte[8];
        byte[] result_data=new byte[p_padding.length];
        //密文和明文等长；

        for(int i=0;i<g_num;i++){
            System.arraycopy(p_padding,i*8,f_p,0,8);
            //f_p数组 作为临时数组保存
            //逐步的 给入明文分组 8*8=64位的给入 descryUnit函数
            System.arraycopy(descryUnit(f_p,sub_key,flag),0,result_data,i*8,8);
        }


        if (flag==0){
            //解密
            //区别在于 需要把 补充的部分删掉，否则会影响复原结果
            //所以需要原来明文的总长度！
            byte[] p_result_data=new byte[p_origin_length];
            System.arraycopy(result_data,0,p_result_data,0,p_origin_length);
            return  p_result_data;
        }
        return result_data;

    }
    /**加密**/
    public byte[] descryUnit(byte[] p,int k[][],int flag){
        //p 是消息分组 64位
        int[] p_bit=new int[64];

        StringBuilder stringBuilder=new StringBuilder();


        for(int i=0;i<8;i++){
            String p_b=Integer.toBinaryString(p[i]&0xff);
            while (p_b.length()%8!=0){
                p_b="0"+p_b;
            }
            stringBuilder.append(p_b);
        }

        //新建 StringBuilder ； 用于 慢慢转换 p[i]
        //也就是 把原来的p[i] 转换成 stringBuilder 类型
        //这个stringBuilder的用处就是 变成一长串0101010101的数字
        String p_str=stringBuilder.toString();

        for(int i=0;i<64;i++){
            int p_t=Integer.valueOf(p_str.charAt(i));
            if(p_t==48){
                p_t=0;
            }else if(p_t==49){
                p_t=1;
            }else{
                System.out.println("To bit error!");
            }
            p_bit[i]=p_t;
        }


        /***IP置换***/
        int [] p_IP=new int[64];
        for (int i=0;i<64;i++){
            p_IP[i]=p_bit[IP[i]-1];
        }
        if (flag == 1) {
            // 加密
            for (int i = 0; i < 16; i++) {
                L(p_IP, i, flag, k[i]);
                //L 函数是用于 进行16轮中每一轮的 4个步骤
            }
        } else if (flag == 0) {
            // 解密
            for (int i = 15; i > -1; i--) {
                L(p_IP, i, flag, k[i]);
            }
        }

        int[] c=new int[64];

        //逆变换IP矩阵操作
        for(int i=0;i<IP_1.length;i++){
            c[i]=p_IP[IP_1[i]-1];
        }

        //把数组中的0 和 1 逐渐

        byte[] c_byte=new byte[8];
        for(int i=0;i<8;i++){
            c_byte[i]=(byte) ((c[8*i]<<7)+(c[8*i+1]<<6)+(c[8*i+2]<<5)+(c[8*i+3]<<4)+(c[8*i+4]<<3)+(c[8*i+5]<<2)+(c[8*i+6]<<1)+(c[8*i+7]));
        }
        return c_byte;


    }

    public void L(int[] M, int times, int flag, int[] keyarray){
        // L参数 分别是 经过IP转换的数组； 当前次数； 是加密还是解密； k就是密钥数组
        //函数目的是用来
        int[] L0=new int[32];
        int[] R0=new int[32];
        int[] L1=new int[32];
        int[] R1=new int[32];
        int[] f=new int[32];

        System.arraycopy(M,0,L0,0,32);
        //分成 32位 左边和右边
        System.arraycopy(M,32,R0,0,32);

        L1=R0;
        //第一轮

        f=fFuction(R0,keyarray);
        //轮函数

        //下面是 异或 ； 轮函数结果与L 进行异或；
        //异或的结果放置到 R中
        for(int j=0;j<32;j++){
            R1[j]=L0[j]^f[j];
            //将异或完的结果；再次放回到M矩阵中去
            //但是这个返回需要考虑到 是加密还是解密 以及 次数的问题
            if (((flag == 0) && (times == 0)) || ((flag == 1) && (times == 15))) {
                M[j] = R1[j];
                M[j + 32] = L1[j];
            }
            else {
                M[j] = L1[j];
                M[j + 32] = R1[j];
            }
        }

    }


    //轮函数 包括四步骤

    //置换表E
    //与48位子密钥做异或
    //把48位结果送到8个S-boxes 得到32位结果
    //最后在置换P矩阵再次 置换一遍

    public int[] fFuction(int [] r_content,int [] key){
        int[] result=new int[32];
        int[] e_k=new int[48];
        for(int i=0;i<E.length;i++){
            e_k[i]=r_content[E[i]-1]^key[i];
            //置换并且和Key进行异或
        }

        /********S盒替换:由48位变32位，现分割e_k，然后再进行替换*********/
        int[][] s=new int[8][6];
        int[]s_after=new int[32];
        for(int i=0;i<8;i++){
            System.arraycopy(e_k,i*6,s[i],0,6);
            int r=(s[i][0]<<1)+ s[i][5];
            //横坐标
            int c=(s[i][1]<<3)+(s[i][2]<<2)+(s[i][3]<<1)+s[i][4];
            //纵坐标
            String str=Integer.toBinaryString(S_Box[i][r][c]);
            //str是替换后的结果； 对替换后的结果补充0
            while (str.length()<4){
                str="0"+str;
            }

            //之后进行置换操作
            for(int j=0;j<4;j++){
                int p=Integer.valueOf(str.charAt(j));
                if(p==48){
                    p=0;
                }else if(p==49){
                    p=1;
                }else{
                    System.out.println("To bit error!");
                }
                s_after[4*i+j]=p;
            }

        }
        /******S盒替换结束*******/
        /****P盒替代****/
        for(int i=0;i<P.length;i++){
            result[i]=s_after[P[i]-1];
        }
        return result;

    }



    /**生成子密钥**/
    public void generateKeys(String key){
        while (key.length()<8){
            key=key+key;
        }
        key=key.substring(0,8);
        byte[] keys=key.getBytes();
        //取字符串key前8位，getBytes()
        int[] k_bit=new int[64];
        //取位值
        for(int i=0;i<8;i++){
            String k_str=Integer.toBinaryString(keys[i]&0xff);
            //&0xff是因为 这里用到Integer 需要转变成 正数
            //toBinaryString用于把int转变成 二进制 但是需要补充0
            //一般确实是少的 需要补充0
            int temp=k_str.length();
            if(k_str.length()<8){
                for(int t=0;t<8-temp;t++){
                    k_str="0"+k_str;
                }
            }
            //接下来把String k_str转变成int 值 1 or 0
            for(int j=0;j<8;j++){
                //转换成 int类型 使用 charAt定位char，然后转换成值
                int p=Integer.valueOf(k_str.charAt(j));
                if(p==48){//'0'对于的是 48 int
                    p=0;
                }else if(p==49){
                    p=1;
                }else{
                    System.out.println("To bit error!");
                }
                k_bit[i*8+j]=p;
            }
        }
        //k_bit是初始的64位长密钥，下一步开始进行替换
        /***********PC-1压缩****************/
        int [] k_new_bit=new int[56];
        for(int i=0;i<PC1.length;i++){
            k_new_bit[i]=k_bit[PC1[i]-1];//这个减1注意点
            //-1 是因为是从1-57 而不是0-56
        }
        /**************************/
        int[] c0=new int[28];
        int[] d0=new int[28];
        System.arraycopy(k_new_bit,0,c0,0,28);//进行拆分
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int Length)

        System.arraycopy(k_new_bit,28,d0,0,28);

        //拆分成 c0 d0

        for(int i=0;i<16;i++){
            int[] c1=new int[28];
            int[] d1=new int[28];

            //LFT 循环左移次数
            if(LFT[i]==1){
                //用复制代替循环左移
                System.arraycopy(c0,1,c1,0,27);
                c1[27]=c0[0];
                System.arraycopy(d0,1,d1,0,27);
                d1[27]=d0[0];

            }else if(LFT[i]==2){

                System.arraycopy(c0,2,c1,0,26);
                c1[26]=c0[0];
                c1[27]=c0[1];//这里手残之前写成c1

                System.arraycopy(d0,2,d1,0,26);
                d1[26]=d0[0];
                d1[27]=d0[1];

            }else{

                System.out.println("LFT Error!");
            }

            int[] tmp=new int[56];

            //开始进行合并
            System.arraycopy(c1,0,tmp,0,28);
            System.arraycopy(d1,0,tmp,28,28);


            for (int j=0;j<PC2.length;j++){//PC2压缩置换
                sub_key[i][j]= tmp[PC2[j]-1];
                //sub_key 数组是16×48 大小；
                //这里是提前把所有的sub_key都保存好了
                //已被后续是6轮循环使用

            }
            //因为接下来要进入下一个for循环；
            //所以需要 重新赋值

            c0=c1;
            d0=d1;
        }

    }

}
