package com.github.mrmks.mc.csf.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class NBTJsonUtilClassVisitor extends ClassVisitor {

    private final boolean[] f = new boolean[]{false, false, false};
    public NBTJsonUtilClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!f[0] && "LoadFile".equals(name) && "(Ljava/io/File;)Lnet/minecraft/nbt/NBTTagCompound;".equals(desc)) {
            MethodVisitor mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
            mv.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            mv.visitLabel(label0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "com/github/mrmks/mc/injector/InjectorJsonUtil", "LoadFile", "(Ljava/io/File;)Lnet/minecraft/nbt/NBTTagCompound;", false);
            mv.visitInsn(ARETURN);
            mv.visitLabel(label1);
            mv.visitLocalVariable("file", "Ljava/io/File;",null,label0, label1, 0);
            mv.visitMaxs(1,1);
            mv.visitEnd();
            f[0] = true;
            return null;
        } else if (!f[1] && "SaveFile".equals(name) && "(Ljava/io/File;Lnet/minecraft/nbt/NBTTagCompound;)V".equals(desc)) {
            MethodVisitor mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
            Label label0 = new Label();
            Label label1 = new Label();
            mv.visitCode();
            mv.visitLabel(label0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, "com/github/mrmks/mc/injector/InjectorJsonUtil", "SaveFile", "(Ljava/io/File;Lnet/minecraft/nbt/NBTTagCompound;)V", false);
            mv.visitInsn(RETURN);
            mv.visitLabel(label1);
            mv.visitLocalVariable("file", "Ljava/io/File;", null, label0, label1, 0);
            mv.visitLocalVariable("tag", "Lnet/minecraft/nbt/NBTTagCompound;", null, label0, label1, 1);
            mv.visitMaxs(2,2);
            mv.visitEnd();
            f[1] = true;
            return null;
        } else if (!f[2] && "Convert".equals(name) && "(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;".equals(desc)) {
            MethodVisitor mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
            mv.visitCode();
            Label label0 = new Label();
            mv.visitLabel(label0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESTATIC, "com/github/mrmks/mc/injector/InjectorJsonUtil","Convert", "(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;", false);
            mv.visitInsn(ARETURN);
            Label label1 = new Label();
            mv.visitLabel(label1);
            mv.visitLocalVariable("json", "Ljava/lang/String;", null, label0, label1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
            f[2] = true;
            return null;
        } else return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
