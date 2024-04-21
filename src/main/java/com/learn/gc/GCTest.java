package com.learn.gc;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class GCTest {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        int[] a = new int[1024*1024];
//        int[] b= new int[1024*1024];
//        int[] c = new int[1024*1024];
//
//        a = null;
//        b = null;
//        c = null;
//
//        Thread.sleep(1000);
//        int[] d = new int[1024*1024];
//
//        System.gc();

        binLoader classLoader = new binLoader();
        Class<?> clazz = classLoader.loadClass("test1");
        Object object = clazz.getConstructor().newInstance();
        object.getClass().getMethod("func").invoke(object);
    }

    public static byte[] genClass() throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = ClassPool.getDefault().getOrNull("test1");
        if (ctClass != null) {
            ctClass.defrost();
        }
        ctClass = pool.makeClass("test1");
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "func", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(\"testttt\");}");
        ctClass.addMethod(ctMethod);
        return ctClass.toBytecode();
    }

    static class binLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name.equals("test1")) {
                try {
                    byte[] v = genClass();
                    return defineClass("test1", genClass(), 0, v.length);
                } catch (CannotCompileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return super.findClass(name);
        }
    }


}
