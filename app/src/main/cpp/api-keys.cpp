//
// Created by Assem Mahrous on 12/21/2019.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
net.example.com.cleansample
Net_example_com_cleansample_SecureapiApplicationsample_APIKeyLibrary_getAPIKey(JNIEnv* env, jobject /* this */) {
    std::string api_key = "aHR0cDovL2FwaS5hY21lLmludGVybmF0aW9uYWwv";
    return env->NewStringUTF(api_key.c_str());
}
