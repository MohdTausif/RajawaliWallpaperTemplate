package com.mydomain.wallpapers.mywallpaper;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.animation.Animation3D;
import rajawali.animation.RotateAnimation3D;
import rajawali.lights.ALight;
import rajawali.lights.DirectionalLight;
import rajawali.math.Number3D;
import rajawali.primitives.Cube;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MyWallpaperRenderer extends RajawaliRenderer {
	private Animation3D mAnim;
	
	public MyWallpaperRenderer(Context context) {
		super(context);
		setFrameRate(60);
	}
	
	public void initScene() {
		ALight light = new DirectionalLight();
		light.setPower(1);
		light.setPosition(0, 0, -5);
		mCamera.setPosition(0, 0, -7);
		mCamera.setLookAt(0, 0, 0);

		Cube cube = new Cube(1);
		cube.addLight(light);
		cube.getMaterial().setUseColor(true);
		cube.setColor(0xff00ff00);
		addChild(cube);
		
		mAnim = new RotateAnimation3D(new Number3D(0, 360, 0));
		mAnim.setDuration(8000);
		mAnim.setRepeatCount(Animation3D.INFINITE);
		mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
		mAnim.setTransformable3D(cube);
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		mAnim.start();
	}

	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
	}
}