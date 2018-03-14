package Util;

public class MyAES {
    //S盒
    public static final byte[] sBox = {
            (byte)0x63,(byte)0x7c,(byte)0x77,(byte)0x7b,(byte)0xf2,(byte)0x6b,(byte)0x6f,(byte)0xc5,
            (byte)0x30,(byte)0x01,(byte)0x67,(byte)0x2b,(byte)0xfe,(byte)0xd7,(byte)0xab,(byte)0x76,
            (byte)0xca,(byte)0x82,(byte)0xc9,(byte)0x7d,(byte)0xfa,(byte)0x59,(byte)0x47,(byte)0xf0,
            (byte)0xad,(byte)0xd4,(byte)0xa2,(byte)0xaf,(byte)0x9c,(byte)0xa4,(byte)0x72,(byte)0xc0,
            (byte)0xb7,(byte)0xfd,(byte)0x93,(byte)0x26,(byte)0x36,(byte)0x3f,(byte)0xf7,(byte)0xcc,
            (byte)0x34,(byte)0xa5,(byte)0xe5,(byte)0xf1,(byte)0x71,(byte)0xd8,(byte)0x31,(byte)0x15,
            (byte)0x04,(byte)0xc7,(byte)0x23,(byte)0xc3,(byte)0x18,(byte)0x96,(byte)0x05,(byte)0x9a,
            (byte)0x07,(byte)0x12,(byte)0x80,(byte)0xe2,(byte)0xeb,(byte)0x27,(byte)0xb2,(byte)0x75,
            (byte)0x09,(byte)0x83,(byte)0x2c,(byte)0x1a,(byte)0x1b,(byte)0x6e,(byte)0x5a,(byte)0xa0,
            (byte)0x52,(byte)0x3b,(byte)0xd6,(byte)0xb3,(byte)0x29,(byte)0xe3,(byte)0x2f,(byte)0x84,
            (byte)0x53,(byte)0xd1,(byte)0x00,(byte)0xed,(byte)0x20,(byte)0xfc,(byte)0xb1,(byte)0x5b,
            (byte)0x6a,(byte)0xcb,(byte)0xbe,(byte)0x39,(byte)0x4a,(byte)0x4c,(byte)0x58,(byte)0xcf,
            (byte)0xd0,(byte)0xef,(byte)0xaa,(byte)0xfb,(byte)0x43,(byte)0x4d,(byte)0x33,(byte)0x85,
            (byte)0x45,(byte)0xf9,(byte)0x02,(byte)0x7f,(byte)0x50,(byte)0x3c,(byte)0x9f,(byte)0xa8,
            (byte)0x51,(byte)0xa3,(byte)0x40,(byte)0x8f,(byte)0x92,(byte)0x9d,(byte)0x38,(byte)0xf5,
            (byte)0xbc,(byte)0xb6,(byte)0xda,(byte)0x21,(byte)0x10,(byte)0xff,(byte)0xf3,(byte)0xd2,
            (byte)0xcd,(byte)0x0c,(byte)0x13,(byte)0xec,(byte)0x5f,(byte)0x97,(byte)0x44,(byte)0x17,
            (byte)0xc4,(byte)0xa7,(byte)0x7e,(byte)0x3d,(byte)0x64,(byte)0x5d,(byte)0x19,(byte)0x73,
            (byte)0x60,(byte)0x81,(byte)0x4f,(byte)0xdc,(byte)0x22,(byte)0x2a,(byte)0x90,(byte)0x88,
            (byte)0x46,(byte)0xee,(byte)0xb8,(byte)0x14,(byte)0xde,(byte)0x5e,(byte)0x0b,(byte)0xdb,
            (byte)0xe0,(byte)0x32,(byte)0x3a,(byte)0x0a,(byte)0x49,(byte)0x06,(byte)0x24,(byte)0x5c,
            (byte)0xc2,(byte)0xd3,(byte)0xac,(byte)0x62,(byte)0x91,(byte)0x95,(byte)0xe4,(byte)0x79,
            (byte)0xe7,(byte)0xc8,(byte)0x37,(byte)0x6d,(byte)0x8d,(byte)0xd5,(byte)0x4e,(byte)0xa9,
            (byte)0x6c,(byte)0x56,(byte)0xf4,(byte)0xea,(byte)0x65,(byte)0x7a,(byte)0xae,(byte)0x08,
            (byte)0xba,(byte)0x78,(byte)0x25,(byte)0x2e,(byte)0x1c,(byte)0xa6,(byte)0xb4,(byte)0xc6,
            (byte)0xe8,(byte)0xdd,(byte)0x74,(byte)0x1f,(byte)0x4b,(byte)0xbd,(byte)0x8b,(byte)0x8a,
            (byte)0x70,(byte)0x3e,(byte)0xb5,(byte)0x66,(byte)0x48,(byte)0x03,(byte)0xf6,(byte)0x0e,
            (byte)0x61,(byte)0x35,(byte)0x57,(byte)0xb9,(byte)0x86,(byte)0xc1,(byte)0x1d,(byte)0x9e,
            (byte)0xe1,(byte)0xf8,(byte)0x98,(byte)0x11,(byte)0x69,(byte)0xd9,(byte)0x8e,(byte)0x94,
            (byte)0x9b,(byte)0x1e,(byte)0x87,(byte)0xe9,(byte)0xce,(byte)0x55,(byte)0x28,(byte)0xdf,
            (byte)0x8c,(byte)0xa1,(byte)0x89,(byte)0x0d,(byte)0xbf,(byte)0xe6,(byte)0x42,(byte)0x68,
            (byte)0x41,(byte)0x99,(byte)0x2d,(byte)0x0f,(byte)0xb0,(byte)0x54,(byte)0xbb,(byte)0x16
    };

    //逆S盒
    public static final byte[] isBox = {
            (byte)0x52,(byte)0x09,(byte)0x6a,(byte)0xd5,(byte)0x30,(byte)0x36,(byte)0xa5,(byte)0x38,
            (byte)0xbf,(byte)0x40,(byte)0xa3,(byte)0x9e,(byte)0x81,(byte)0xf3,(byte)0xd7,(byte)0xfb,
            (byte)0x7c,(byte)0xe3,(byte)0x39,(byte)0x82,(byte)0x9b,(byte)0x2f,(byte)0xff,(byte)0x87,
            (byte)0x34,(byte)0x8e,(byte)0x43,(byte)0x44,(byte)0xc4,(byte)0xde,(byte)0xe9,(byte)0xcb,
            (byte)0x54,(byte)0x7b,(byte)0x94,(byte)0x32,(byte)0xa6,(byte)0xc2,(byte)0x23,(byte)0x3d,
            (byte)0xee,(byte)0x4c,(byte)0x95,(byte)0x0b,(byte)0x42,(byte)0xfa,(byte)0xc3,(byte)0x4e,
            (byte)0x08,(byte)0x2e,(byte)0xa1,(byte)0x66,(byte)0x28,(byte)0xd9,(byte)0x24,(byte)0xb2,
            (byte)0x76,(byte)0x5b,(byte)0xa2,(byte)0x49,(byte)0x6d,(byte)0x8b,(byte)0xd1,(byte)0x25,
            (byte)0x72,(byte)0xf8,(byte)0xf6,(byte)0x64,(byte)0x86,(byte)0x68,(byte)0x98,(byte)0x16,
            (byte)0xd4,(byte)0xa4,(byte)0x5c,(byte)0xcc,(byte)0x5d,(byte)0x65,(byte)0xb6,(byte)0x92,
            (byte)0x6c,(byte)0x70,(byte)0x48,(byte)0x50,(byte)0xfd,(byte)0xed,(byte)0xb9,(byte)0xda,
            (byte)0x5e,(byte)0x15,(byte)0x46,(byte)0x57,(byte)0xa7,(byte)0x8d,(byte)0x9d,(byte)0x84,
            (byte)0x90,(byte)0xd8,(byte)0xab,(byte)0x00,(byte)0x8c,(byte)0xbc,(byte)0xd3,(byte)0x0a,
            (byte)0xf7,(byte)0xe4,(byte)0x58,(byte)0x05,(byte)0xb8,(byte)0xb3,(byte)0x45,(byte)0x06,
            (byte)0xd0,(byte)0x2c,(byte)0x1e,(byte)0x8f,(byte)0xca,(byte)0x3f,(byte)0x0f,(byte)0x02,
            (byte)0xc1,(byte)0xaf,(byte)0xbd,(byte)0x03,(byte)0x01,(byte)0x13,(byte)0x8a,(byte)0x6b,
            (byte)0x3a,(byte)0x91,(byte)0x11,(byte)0x41,(byte)0x4f,(byte)0x67,(byte)0xdc,(byte)0xea,
            (byte)0x97,(byte)0xf2,(byte)0xcf,(byte)0xce,(byte)0xf0,(byte)0xb4,(byte)0xe6,(byte)0x73,
            (byte)0x96,(byte)0xac,(byte)0x74,(byte)0x22,(byte)0xe7,(byte)0xad,(byte)0x35,(byte)0x85,
            (byte)0xe2,(byte)0xf9,(byte)0x37,(byte)0xe8,(byte)0x1c,(byte)0x75,(byte)0xdf,(byte)0x6e,
            (byte)0x47,(byte)0xf1,(byte)0x1a,(byte)0x71,(byte)0x1d,(byte)0x29,(byte)0xc5,(byte)0x89,
            (byte)0x6f,(byte)0xb7,(byte)0x62,(byte)0x0e,(byte)0xaa,(byte)0x18,(byte)0xbe,(byte)0x1b,
            (byte)0xfc,(byte)0x56,(byte)0x3e,(byte)0x4b,(byte)0xc6,(byte)0xd2,(byte)0x79,(byte)0x20,
            (byte)0x9a,(byte)0xdb,(byte)0xc0,(byte)0xfe,(byte)0x78,(byte)0xcd,(byte)0x5a,(byte)0xf4,
            (byte)0x1f,(byte)0xdd,(byte)0xa8,(byte)0x33,(byte)0x88,(byte)0x07,(byte)0xc7,(byte)0x31,
            (byte)0xb1,(byte)0x12,(byte)0x10,(byte)0x59,(byte)0x27,(byte)0x80,(byte)0xec,(byte)0x5f,
            (byte)0x60,(byte)0x51,(byte)0x7f,(byte)0xa9,(byte)0x19,(byte)0xb5,(byte)0x4a,(byte)0x0d,
            (byte)0x2d,(byte)0xe5,(byte)0x7a,(byte)0x9f,(byte)0x93,(byte)0xc9,(byte)0x9c,(byte)0xef,
            (byte)0xa0,(byte)0xe0,(byte)0x3b,(byte)0x4d,(byte)0xae,(byte)0x2a,(byte)0xf5,(byte)0xb0,
            (byte)0xc8,(byte)0xeb,(byte)0xbb,(byte)0x3c,(byte)0x83,(byte)0x53,(byte)0x99,(byte)0x61,
            (byte)0x17,(byte)0x2b,(byte)0x04,(byte)0x7e,(byte)0xba,(byte)0x77,(byte)0xd6,(byte)0x26,
            (byte)0xe1,(byte)0x69,(byte)0x14,(byte)0x63,(byte)0x55,(byte)0x21,(byte)0x0c,(byte)0x7d,
    };



    public static byte[][] rCon = {
            {(byte)0x00, 0x00, 0x00, 0x00},
            {(byte)0x01, 0x00, 0x00, 0x00},
            {(byte)0x02, 0x00, 0x00, 0x00},
            {(byte)0x04, 0x00, 0x00, 0x00},
            {(byte)0x08, 0x00, 0x00, 0x00},
            {(byte)0x10, 0x00, 0x00, 0x00},
            {(byte)0x20, 0x00, 0x00, 0x00},
            {(byte)0x40, 0x00, 0x00, 0x00},
            {(byte)0x80, 0x00, 0x00, 0x00},
            {(byte)0x1b, 0x00, 0x00, 0x00},
            {(byte)0x36, 0x00, 0x00, 0x00}
    };
    private static int w[] = new int[44];
    // 把字节变量转换成int型
    private static int byte2Int(byte b) {
        return (b & 0xff);
    }

    //实现字节代换：用S盒执行，if a[2,2] = 5B then state[2,2] = SBox[5,11]
    private static byte[][] subBytes(byte[][] state) {
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<4; j++) {
                state[i][j] = sBox[byte2Int(state[i][j])];
            }
        }
        return state;
    }

    //逆字节代换，使用逆S盒
    private static byte[][] isubBytes(byte[][] state) {
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<4; j++) {
                state[i][j] = isBox[byte2Int(state[i][j])];
            }
        }
        return state;
    }

    //行移位
    private static byte[][] shiftRows(byte[][] state) {
        for (int i = 1; i<4; i++ ) {
            byte temp[] = new byte[4];
            for (int j = 0; j<4; j++ ) {
                temp[j] = state[i][(i+j)%4];
            }
            System.arraycopy(temp,0,state[i],0,4);
        }
        return state;
    }

    //行移位的逆变换
    private static byte[][] ishiftRows(byte[][] state) {
        for (int i = 1; i<4; i++) {
            byte temp[] = new byte[4];
            for (int j = 0; j<4; j++) {
               temp[j] = state[i][(4-i+j)%4];
            }
            System.arraycopy(temp,0,state[i],0,4);
        }
        return state;
    }

    private static byte[][] mixColumns(byte[][] state) {
        byte[] a = new byte[4];// a•{01} in GF(2^8)
        byte[] b = new byte[4];// a•{01} in GF(2^8)
        byte[] c = new byte[4];// a•{02} in GF(2^8)
        byte[] d = new byte[4];// a•{03} in GF(2^8)
        for(int y=0; y<4; y++) {
            for(int x=0; x<4; x++) {
                a[x] = gfmultby01(state[x][y]);
                b[x] = gfmultby01(state[x][y]);
                c[x] = gfmultby02(state[x][y]);
                d[x] = gfmultby03(state[x][y]);
            }
            state[0][y] = (byte)(c[0]^d[1]^b[2]^a[3]);// 2a0 + 3a1 +  a2 +  a3
            state[1][y] = (byte)(a[0]^c[1]^d[2]^b[3]);//  a0 + 2a1 + 3a2 +  a3
            state[2][y] = (byte)(b[0]^a[1]^c[2]^d[3]);//  a0 +  a1 + 2a2 + 3a3
            state[3][y] = (byte)(d[0]^b[1]^a[2]^c[3]);// 3a0 +  a1 +  a2 + 2a3
        }
        return state;
    }

    private static byte[][] imixColumns(byte[][] state) {
        byte[] a = new byte[4];// a•{09} in GF(2^8)
        byte[] b = new byte[4];// a•{13} in GF(2^8)
        byte[] c = new byte[4];// a•{11} in GF(2^8)
        byte[] d = new byte[4];// a•{14} in GF(2^8)
        for(int y=0; y<4; y++) {
            for(int x=0; x<4; x++) {
                a[x] = gfmultby09(state[x][y]);
                b[x] = gfmultby0d(state[x][y]);
                c[x] = gfmultby0e(state[x][y]);
                d[x] = gfmultby0b(state[x][y]);
            }
            state[0][y] = (byte)(c[0]^d[1]^b[2]^a[3]);// 14a0 + 11a1 + 13a2 +  9a3
            state[1][y] = (byte)(a[0]^c[1]^d[2]^b[3]);//  9a0 + 14a1 + 11a2 + 13a3
            state[2][y] = (byte)(b[0]^a[1]^c[2]^d[3]);// 13a0 +  9a1 + 14a2 + 11a3
            state[3][y] = (byte)(d[0]^b[1]^a[2]^c[3]);// 11a0 + 13a1 + 9a2 + 14a3
        }
        return state;
    }

    private static byte gfmultby01(byte b) {
        return b;
    }

    private static byte gfmultby02(byte b) {
        return b<0?(byte)((b << 1)^0x1b):(byte)(b << 1);
    }

    private static byte gfmultby03(byte b) {
        byte v01 = gfmultby01(b);
        byte v02 = gfmultby02(b);
        return (byte)(v02^v01);
    }

    private static byte gfmultby09(byte b) {
        byte v01 = gfmultby01(b);
        byte v02 = gfmultby02(b);
        byte v04 = gfmultby02(v02);
        byte v08 = gfmultby02(v04);
        return (byte)(v08^v01);
    }

    private static byte gfmultby0b(byte b) {
        byte v01 = gfmultby01(b);
        byte v02 = gfmultby02(b);
        byte v04 = gfmultby02(v02);
        byte v08 = gfmultby02(v04);
        return (byte)(v08^v02^v01);
    }

    private static byte gfmultby0d(byte b) {
        byte v01 = gfmultby01(b);
        byte v02 = gfmultby02(b);
        byte v04 = gfmultby02(v02);
        byte v08 = gfmultby02(v04);
        return (byte)(v08^v04^v01);
    }

    private static byte gfmultby0e(byte b) {
        byte v02 = gfmultby02(b);
        byte v04 = gfmultby02(v02);
        byte v08 = gfmultby02(v04);
        return (byte)(v08^v04^v02);
    }

    private static byte[][] addRoundKey(byte[][] state, byte[][] w, int rnd) {
        for(int x=0; x<4; x++) {
            for(int y=0; y<4; y++) {
                state[x][y] ^= w[rnd*4+y][x];
            }
        }
        return state;
    }

    private static byte[] rotWord(byte[] bytes) {
        byte b = bytes[0];
        for (int i = 0; i < 3; i++) {
            bytes[i] = bytes[i+1];
        }
        bytes[3] = b;
        return bytes;
    }

    private static byte[] subWord(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = sBox[byte2Int(bytes[i])];
        }
        return bytes;
    }

    public static byte[][] keyExpansion(byte[] key) {
        int nb = 4;
        int nk = 4;//aes 128/192/256 - 4/6/8
        int nr = 10;//aes 128/192/256 - 10/12/14

        byte[][] w = new byte[nb*(nr +1)][4];
        for(int i=0; i<key.length; i++) {
            w[i/4][i%4] = key[i];
        }
        byte[] temp = new byte[4];
        for(int i=nk; i<(nb*(nr +1)); i++) {
            for(int j=0; j<4; j++) {
                temp[j] = w[i-1][j];
            }
            if(i%nk == 0) {
                temp = subWord(rotWord(temp));
                for(int j=0; j<4; j++) {
                    temp[j] ^= rCon[i/nk][j];
                }
            } else if (nk > 6 && i%nk == 4) {
                temp = subWord(temp);
            }
            for(int j=0; j<4; j++) {
                w[i][j] = (byte)(w[i-nk][j] ^ temp[j]);
            }
        }
        return w;
    }

    public static byte[] encipher(byte[] content, byte[][] w) {
        int nb = 4;
        int nr = w.length/nb - 1;
        byte[][] state = new byte[4][4];
        for (int i = 0; i < content.length; i++) {
            state[i%4][i/4] = content[i];
        }

        state = addRoundKey(state, w, 0);

        for (int i = 1; i < nr; i++) {
            state = subBytes(state);
            state = shiftRows(state);
            state = mixColumns(state);
            state = addRoundKey(state, w, i);
        }

        state = subBytes(state);
        state = shiftRows(state);
        state = addRoundKey(state, w, nr);

        byte[] temp = new byte[16];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = state[i%4][i/4];
        }
        return temp;
    }

    public static byte[] decipher(byte[] content, byte[][] w) {//加密算法的逆过程
        int nb = 4;
        int nr = w.length/nb - 1;
        byte[][] state = new byte[4][4];
        for (int i = 0; i < content.length; i++) {
            state[i%4][i/4] = content[i];
        }
        state = addRoundKey(state, w, nr);
        state = ishiftRows(state);
        state = isubBytes(state);

        for (int i = nr-1; i > 0; i--) {
            state = addRoundKey(state, w, i);
            state = imixColumns(state);
            state = ishiftRows(state);
            state = isubBytes(state);
        }

        state = addRoundKey(state, w, 0);

        byte[] temp = new byte[16];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = state[i%4][i/4];
        }
        return temp;
    }

    public static void printState(byte[][] state) {
        for (int i = 0; i < 4; i++) {
            System.out.print("[");
            for (int j = 0; j < 4; j++) {
                System.out.print(parseByte2HexStr(state[i][j]));
            }
            System.out.print("]");
        }
        System.out.println();
    }

    public static void printW(byte[][] w) {
        for (int i = 0; i < w.length; i++) {
            System.out.print("[");
            for (int j = 0; j < 4; j++) {
                System.out.print(parseByte2HexStr(w[i][j]));
            }
            System.out.print("]");
        }
        System.out.println();
    }

    public static String parseByte2HexStr(byte buf) {
        StringBuffer sb = new StringBuffer();
        String hex = Integer.toHexString(buf & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        sb.append(hex.toUpperCase());
        return sb.toString();
    }
}
