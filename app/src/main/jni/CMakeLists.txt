cmake_minimum_required(VERSION 3.4.1)
find_library(log-lib log)
add_library(jnitext SHARED jnitext.c)
target_link_libraries(jnitext ${log-lib})