//
// Created by ywq on 2019/3/19.
//
#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_rx_learnjni_MainActivity_helloJni(JNIEnv *env, jobject instance) {

    // TODO
    struct {
        char *name;  //姓名
        int num;  //学号
        int age;  //年龄
        char group;  //所在小组
        float score;  //成绩

    }stu;

    stu.name="张三";
    stu.age=18;
    stu.num=9999;
    stu.group='A';


    return (*env)->NewStringUTF(env, stu.name);
}

JNIEXPORT jstring JNICALL
Java_com_rx_learnjni_MainActivity_openFile(JNIEnv *env, jobject instance) {

    // TODO

    FILE *fp;
    char str[102] = {0}, strTemp[100];
    if( (fp=fopen("/storage/emulated/0/demo.txt", "at+")) == NULL ){
        puts("Fail to open file!");
        exit(0);
    }
    printf("Input a string:");
    strcat(str, "\n");
    strcat(str, "Input a string:");
    fputs(str, fp);
    fclose(fp);

    return (*env)->NewStringUTF(env, "success");
}