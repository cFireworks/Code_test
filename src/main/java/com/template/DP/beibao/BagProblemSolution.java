package com.template.DP.beibao;

/**
 * @description: 背包问题
 * @author: cfireworks
 * @create: 2020-06-06 09:29
 **/
public class BagProblemSolution {

    /**
     * @description: 01 背包问题
     * 问题：有N件物品和一个容量V的背包，放入第i件物品耗费空间C_i,得到的价值是W_i。求解哪些物品装入背包可使价值总和最大。
     * 状态定义：F[i,v]表示前i件物品放入一个容量为v的背包可以获得的最大价值
     * 状态转移方程：F[i,v] = max{F[i-1,v], F[i-1,v-C_i]+W_i}
     * 时间复杂度：O(NV), 空间复杂度:O(NV)
     * 优化思路：
     *     1)空间优化：通过逆序遍历v，使得内循环遍历时一维数组F[v-C_i]可以表示F[i-1,v-C_i]
     *     2)常数优化：二重循环下限可以优化为 max(V-Sum(W_1,W_2,...,W_N), C_i)
     * 初始化细节：1）背包必须装满：F[0] = 0, F[1...V] = MIN_VALUE; 2)背包不必装满：F[1...V] = 0;
     */
    public int zeroOneBag(int N, int V, int[] C, int[] W){
        // 初始化背包
        int[] dp = new int[V+1];
        // 计算
        for(int i=0; i<N; ++i){
            // ZeroOnePack
            for(int v = V; v>=C[i]; --v){
                dp[v] = Math.max(dp[v], dp[v-C[i]]+W[i]);
            }
        }
        return dp[V];
    }
    public void zeroOnePack(int[] dp, int V, int c, int w){
        for(int v = V; v>=c; --v){
            dp[v] = Math.max(dp[v], dp[v-c] + w);
        }
    }

    /**
     * @description: 完全背包问题
     * 问题：有N种物品和一个容量为V的背包，每种物品都有无限件可用。放入第i种物品的耗费空间是C_i，得到的价值是W_i.
     *       求解将哪些物品装入背包，可使价值总和最大
     * 状态定义：按01背包理解，
     * 状态转移方程：F[i,v] = max{F[i-1,v-k*C_i] + k*W_i | 0<= kC_i <= v}
     * 优化：高价低值的物品直接筛去
     *
     */
    public int completeBag(int N, int V, int[] C, int[] W){
        // 初始化背包
        int[] dp = new int[V+1];
        // 计算
        for(int i=0; i<N; ++i){
            // ZeroOnePack
            for(int v = C[i]; v <= V; ++v){
                dp[v] = Math.max(dp[v], dp[v-C[i]]+W[i]);
            }
        }
        return dp[V];
    }
    public void completePack(int[] dp, int V, int c, int w){
        for(int v = c; v <= V; ++v){
            dp[v] = Math.max(dp[v], dp[v-c]+w);
        }
    }
    /**
     * @description: 多重背包问题
     * 问题：有N种物品和一个容量为 V 的背包。第i种物品最多有 Mi 件可用，每件耗费
     *       的空间是 Ci，价值是 Wi 。求解将哪些物品装入背包可使这些物品的耗费的空间
     *       总和不超过背包容量，且价值总和最大。
     * 状态转移：F[i,v] = max{F[i-1,v-k*C_i] + k*W_i | 0<= k <= M_i}
     * 解法：1）转换为01背包问题，将第i件物品分为 占用空间 k*C_i,价值k*W_i 的 log M_i 件物品，使用01背包来做
     */
    public int multiBag(int N, int V, int[] C, int[] W, int[] M){
        int[] dp = new int[V+1];
        for(int i=0; i<N; ++i){
            int c = C[i], w = W[i], m = M[i];
            if(c*m >= V){
                completePack(dp, V, c, w);
            }
            int k = 1;
            while(k < m){
                zeroOnePack(dp, V, k*c, k*w);
                m -= k;
                k *= 2;
            }
            zeroOnePack(dp, V,m*c, m*w);
        }
        return dp[V];
    }
    public void multiPack(int[] dp, int V, int c, int w, int m){
        if(c*m >= V){
            completePack(dp, V, c, w);
        }
        int k = 1;
        while(k < m){
            zeroOnePack(dp, V, k*c, k*w);
            m -= k;
            k *= 2;
        }
        zeroOnePack(dp, V,m*c, m*w);
    }

    /**
     * @description: 混合三种背包问题
     * 问题：混合01背包、完全背包、多重背包，物品有的只可取一次，有的可取无穷次，有的取有限次
     * 解法：
     *       1）01背包与完全背包混合：针对物品属性，内层循环选择顺序或逆序遍历
     *       2）加上多重背包，同理分类调用不同pack方法
     */
    public int mixedBag(int N, int V, int[] C, int[] W, int[] M){
        int[] dp = new int[V+1];
        for(int i=0; i<N; ++i){
            // m --- 1 : 可取1次 n : 可取n次 -1：可取无数次
            int c = C[i], w = W[i], m = M[i];
            if(m == 1){
                zeroOnePack(dp, V, c, w);
            }else if(m == -1){
                completePack(dp, V, c, w);
            }else if(m > 1){
                multiPack(dp, V, c, w, m);
            }
        }
        return dp[V];
    }

    /**
     * @description: 二维费用的背包问题
     * 问题：对于每件物品，具有两种不同的空间消费，选择这件物品必须同时付出这两种代价。每种代价都有一个客付出的
     *       最大值（背包容量）。问怎么选择物品可以达到最大值。
     * 状态转移方程：F[i; v; u] = max{F[i − 1; v; u]; F[i − 1; v − Ci; u − Di] + Wi}
     * tips: 物品个数的限制，是一种隐式二维条件，相当于每个物品有一个数量代价1，背包容量为个数限制
     */
    // TODO: impoements 2d
    public int mixedBag2d(int N, int V,int V2, int[] C , int[] D, int[] W, int[] M, int[] T){
        int[] dp = new int[V+1];
        int[][] dp2d = new int[V+1][V2+1];
        for(int i=0; i<N; ++i){
            // m --- 1 : 可取1次 n : 可取n次 -1：可取无数次
            int c = C[i], w = W[i], m = M[i];
            if(m == 1){
                // zeroOnePack2d(dp, V, c, w);
            }else if(m == -1){
                // completePack2d(dp, V, c, w);
            }else if(m > 1){
                // multiPack2d(dp, V, c, w, m);
            }
        }
        return dp[V];
    }

    /**
     * @description: 分组背包问题
     * 问题：有N件物品和一个容量为V 的背包。第i件物品的费用是Ci，价值是Wi。这
     *       些物品被划分为K组，每组中的物品互相冲突，最多选一件。求解将哪些物品
     *       装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     * 状态转移：F [k; v] = max{F [k − 1; v]; F [k − 1; v − Ci] + Wi | item i in group k}
     * for k = 1 to K
     *     for v = V to 0
     *         for item i in group k
     *             F[v] = max{F[v], F[v-Ci]+Wi}
     */















}
