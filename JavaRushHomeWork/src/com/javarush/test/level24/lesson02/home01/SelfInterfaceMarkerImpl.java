package com.javarush.test.level24.lesson02.home01;

import com.javarush.test.level24.lesson02.home01.SelfInterfaceMarker;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{

    public SelfInterfaceMarkerImpl()
    {
    }

    public void Method (){
    }

    public void Method2 (){
    }

    static class UnsupportedInterfaceMarkerException extends Exception{
        UnsupportedInterfaceMarkerException(){}
    }
}


