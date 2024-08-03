## 实验内容
完成一个编译器的前端和后端，通过antlr工具和Java编程完成token分割、词法分析和语法分析，通过Java编程对前端结果进行处理完成语义分析和目标代码生成。将ASTFomatter.java的Main和CodeGenerator的Main逻辑合成一个函数即为这个编译器的前后端结合。修改input.midl后运行程序即可产生对应的结果到result.txt之中。

## 实验环境
- JDK18
- VScode
- antlr-4.7.2

## 实验流程
1. 下载安装antlr，并且按照网上教程通过环境变量的加入和批处理程序的编写，搭配好antlr环境
2. 根据实验要求编写[MIDL.g4](/main/src/MIDL.g4)，然后通过之前的批处理程序在-visitor指令下生成[antlrfile](../src/antlrfile)中的相应的代码
3. 按照实验一要求，定义AST结构并且使用生成的词法和语法分析器，将其放入[astmade](../src/astmade)
4. 按照实验二的要求，对语法结果进行语义分析、构建辅助类计算实际值做出类型判断并且将其构建为一个有实际意义的Bean结构，将其放入[errortest](../src/errortest)
5. 按照实验二的要求，通过语义分析过程中生成的有实际意义的Bean结构进行目标代码的生成，将其放入[gencode](../src/gencode)


## 文件释义

- input.midl：测试语句生成用的文件，在这里面输入后由主程序读取
- SyntaxOut.java: 放入解析后的AST
- MIDL.g4： 按照实验要求编写的词法语法定义
- astmade包中文件: 构建和格式化AST并将其输出
    - ASTFormatter.java：主程序：读取源文件、进行词法和语法解析后生成AST
- errortest包中文件: 进行语义分析并且通过bean作为语法逻辑
    - Entity.java： Java实体作为树的结构内容
    - Specification.java： 树的上层
    - SemanticAnalyzer.java： 语法分析的控制类
    - SymbolChecker.java： 检测类型与值是否匹配的辅助类
    - ExpressionEvaluator.java： 计算数值表达式的辅助类
- gencode包中文件： 通过errortest语义分析的结构来生成相应的代码
- antlrfile包中文件：由MIDL.g4通过"java org.antlr.v4.Tool -visitor MIDL.g4"命令生成的解析文件

## 运行方式

修改input.midl，运行ASTFormatter.java的Main函数生成Syntax.txt，运行CodeGenerator.java生成相应的程序。
可用以下用例进行测试
```
struct F{int64 a=100;float b=0.9e-10;char c='\n';string d="hello";boolean e=false;};
struct Y{}; 
struct W;
struct I{int64 p=1+2-3;int64 q=1*2%4/3;};
struct V{long b;char c='x';double d;int e;char f;string g;boolean h;};
module M{struct L{short c;};};
struct J{int64 x=1|2|3;int64 y=1^2^3;int64 z=1&2&3;int64 w=1>>2<<3;};
struct R{char i;int64 j;struct Q{}k;};
struct X;
struct T{float p='a',q;};//不对应类型的数值
struct H{int64 m=-1,n=+0.5,o=~0;};
struct H{int64 m=-1,n=+0.5,o=~0;};//已定义id
module E{struct D{unsigned long long z=1|2^3&4>>5+6*7/8%~9;};};//错误类型
struct S{long double m;struct N{};}; //错误类型
```
运行ASTFormatter.java的Main函数，得到如下的Syntax.txt：
```
specification(
        struct( 
            ID:F 
            member(
                int64
                ID:a
                value=(100
                )
            )
            member(
                float
                ID:b
                value=(0.9e-10
                )
            )
            member(
                char 
                ID:c
                value=('\n'
                )
            )
            member(
                string 
                ID:d
                value=("hello"
                )
            )
            member(
                boolean 
                ID:e
                value=(false
                )
            )
        ) 
 ) 
specification(
        struct( 
            ID:Y 
        ) 
 ) 
specification(
    struct( 
        ID:W 
    )
 ) 
specification(
        struct( 
            ID:I 
            member(
                int64
                ID:p
                value=(
                    +(
                        1 
                    -(
                        2 3
                    )
                    )
                )
            )
            member(
                int64
                ID:q
                value=(
                    *(
                        1 
                    %(
                        2 
                    /(
                        4 3
                    )
                    )
                    )
                )
            )
        ) 
 ) 
specification(
        struct( 
            ID:V 
            member(
                long
                ID:b
            )
            member(
                char 
                ID:c
                value=('x'
                )
            )
            member(
                double
                ID:d
            )
            member(
                ID:e
            )
            member(
                char 
                ID:f
            )
            member(
                string 
                ID:g
            )
            member(
                boolean 
                ID:h
            )
        ) 
 ) 
specification(
    module( 
        ID:M 
        member: (
                struct( 
                    ID:L 
                    member(
                        short
                        ID:c
                    )
                ) 
        )
    )
 ) 
specification(
        struct( 
            ID:J 
            member(
                int64
                ID:x
                value=(
                    |(
                        1
                    |(
                        23
                    )
                    )
                )
            )
            member(
                int64
                ID:y
                value=(
                    ^(
                        1
                    ^(
                        23
                    )
                    )
                )
            )
            member(
                int64
                ID:z
                value=(
                    &(
                        1
                    &(
                        23
                    )
                    )
                )
            )
            member(
                int64
                ID:w
                value=(
                    >>(
                        1 
                    <<(
                        2 3
                    )
                    )
                )
            )
        ) 
 ) 
specification(
        struct( 
            ID:R 
            member(
                char 
                ID:i
            )
            member(
                int64
                ID:j
            )
            member(
                struct( 
                    ID:Q 
                ) 
                ID:k
            )
        ) 
 ) 
specification(
    struct( 
        ID:X 
    )
 ) 
specification(
        struct( 
            ID:T 
            member(
                float
                ID:p
                value=('a'
                )
                ID:q
            )
        ) 
 ) 
specification(
        struct( 
            ID:H 
            member(
                int64
                ID:m
                value=(
                    -(
                        1
                    )
                )
                ID:n
                value=(
                    +(
                        0.5
                    )
                )
                ID:o
                value=(
                    ~(
                        0
                    )
                )
            )
        ) 
 ) 
specification(
        struct( 
            ID:H 
            member(
                int64
                ID:m
                value=(
                    -(
                        1
                    )
                )
                ID:n
                value=(
                    +(
                        0.5
                    )
                )
                ID:o
                value=(
                    ~(
                        0
                    )
                )
            )
        ) 
 ) 
specification(
    module( 
        ID:E 
        member: (
                struct( 
                    ID:D 
                    member(
                        unsigned long long
                        ID:z
                        value=(
                            |(
                                1
                                ^(
                                    2
                                    &(
                                        3
                                        >>(
                                            4 
                                            +(
                                                5 
                                                *(
                                                    6 
                                                /(
                                                    7 
                                                %(
                                                    8 
                                                    ~(
                                                        9
                                                    )
                                                )
                                                )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                ) 
        )
    )
 ) 
specification(
        struct( 
            ID:S 
            member(
                long double
                ID:m
            )
            member(
                struct( 
                    ID:N 
                ) 
            )
        ) 
 ) 
specification(
        struct( 
            ID:Z 
            member(
                ID:a
            )
        ) 
 ) 
```
运行CodeGenerator.java在终端有如下输出：
```
Type can not match with value! The name is p the value is 'a' the type is float
Already have this id in former: H
Not defined in symbol! The name is unsigned long long
Not defined in symbol! The name is long double
```
并得到这样的最终文件：
```
struct struct {
    int64 a = 100;
    float b = 0.0;
    char c = '\n';
    string d = "hello";
    boolean e = false;
} F;
struct Y;
struct W;
struct struct {
    int64 p = 0;
    int64 q = 0;
} I;
struct struct {
    long b;
    char c = 'x';
    double d;
    null e;
    char f;
    string g;
    boolean h;
} V;
struct module {
    struct struct {
        short c;
    } L;
} M;
struct struct {
    int64 x = 23;
    int64 y = 22;
    int64 z = 1;
    int64 w = 0;
} J;
struct struct {
    char i;
    int64 j;
    struct Q;
} k;
struct X;
struct struct {
} T;
struct struct {
    int64 o = 0;
} H;
struct module {
    struct struct {
    } D;
} E;
struct struct {
    struct N;
} S;
struct struct {
    null a;
} Z;
```
