/*
   Copyright (c) 2014,2015,2016 Ahome' Innovation Technologies. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ait.lienzo.client.core;

import com.ait.lienzo.client.core.Path2D.NativePath2D;
import com.ait.lienzo.client.core.types.ImageData;
import com.ait.lienzo.client.core.types.LinearGradient.LinearGradientJSO;
import com.ait.lienzo.client.core.types.PathPartList.PathPartListJSO;
import com.ait.lienzo.client.core.types.PatternGradient.PatternGradientJSO;
import com.ait.lienzo.client.core.types.RadialGradient.RadialGradientJSO;
import com.ait.lienzo.client.core.types.Shadow.ShadowJSO;
import com.ait.lienzo.client.core.types.TextMetrics;
import com.ait.lienzo.client.core.types.Transform.TransformJSO;
import com.ait.tooling.nativetools.client.collection.NFastDoubleArrayJSO;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

/**
 * This class is used to natively access the Canvas 2D context.
 * 
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#2dcontext">Canvas 2d Context</a> 
 */

public final class NativeContext2D extends JavaScriptObject
{
    private static final native NativeContext2D make_0(CanvasElement element)
    /*-{
		return element.getContext("2d");
    }-*/;

    public static final NativeContext2D make(final CanvasElement element)
    {
        return make_0(element).init();
    }

    protected NativeContext2D()
    {
    }

    private final native NativeContext2D init()
    /*-{
		this.imageSmoothingEnabled = false;

		this.LienzoBackingStorePixelRatio = this.backingStorePixelRatio
				|| this.webkitBackingStorePixelRatio
				|| this.mozBackingStorePixelRatio
				|| this.msBackingStorePixelRatio
				|| this.oBackingStorePixelRatio || 1;

		if (this.setLineDash) {
			this.LienzoSetLineDash = this.setLineDash;

			this.LienzoSetLineDashOffset = function(d) {
				this.lineDashOffset = d;
			};
		} else if (this.webkitLineDash) {
			this.LienzoSetLineDash = function(d) {
				this.webkitLineDash = d;
			};
			this.LienzoSetLineDashOffset = function(d) {
				this.webkitLineDashOffset = d;
			};
		} else if (this.mozDash) {
			this.LienzoSetLineDash = function(d) {
				this.mozDash = d;
			};
			this.LienzoSetLineDashOffset = function(d) {
				this.mozDashOffset = d;
			};
		} else {
			this.LienzoSetLineDash = function(d) {
			};
			this.LienzoSetLineDashOffset = function(d) {
			};
		}
		if (!this.ellipse) {
			this.LienzoEllipse = function(x, y, radiusX, radiusY, rotation,
					startAngle, endAngle, antiClockwise) {
				this.save();
				this.translate(x, y);
				this.rotate(rotation);
				this.scale(radiusX, radiusY);
				this.arc(0, 0, 1, startAngle, endAngle, antiClockwise);
				this.restore();
			};
		} else {
			this.LienzoEllipse = this.ellipse;
		}
		return this;
    }-*/;

    public final native void save()
    /*-{
		this.save();
    }-*/;

    public final native void restore()
    /*-{
		this.restore();
    }-*/;

    public final native void beginPath()
    /*-{
		this.beginPath();
    }-*/;

    public final native void closePath()
    /*-{
		this.closePath();
    }-*/;

    public final native void moveTo(double x, double y)
    /*-{
		this.moveTo(x, y);
    }-*/;

    public final native void lineTo(double x, double y)
    /*-{
		this.lineTo(x, y);
    }-*/;

    public final native void setGlobalCompositeOperation(String operation)
    /*-{
		this.globalCompositeOperation = operation || "source-over";
    }-*/;

    public final native void setLineCap(String lineCap)
    /*-{
		this.lineCap = lineCap || "butt";
    }-*/;

    public final native void setLineJoin(String lineJoin)
    /*-{
		this.lineJoin = lineJoin || "miter";
    }-*/;

    public final native void quadraticCurveTo(double cpx, double cpy, double x, double y)
    /*-{
		this.quadraticCurveTo(cpx, cpy, x, y);
    }-*/;

    public final native void arc(double x, double y, double radius, double startAngle, double endAngle)
    /*-{
		this.arc(x, y, radius, startAngle, endAngle, false);
    }-*/;

    public final native void arc(double x, double y, double radius, double startAngle, double endAngle, boolean antiClockwise)
    /*-{
		this.arc(x, y, radius, startAngle, endAngle, antiClockwise);
    }-*/;

    public final native void ellipse(double x, double y, double radiusX, double radiusY, double rotation, double startAngle, double endAngle, boolean antiClockwise)
    /*-{
		this.LienzoEllipse(x, y, radiusX, radiusY, rotation, startAngle,
				endAngle, antiClockwise);
    }-*/;

    public final native void ellipse(double x, double y, double radiusX, double radiusY, double rotation, double startAngle, double endAngle)
    /*-{
		this.LienzoEllipse(x, y, radiusX, radiusY, rotation, startAngle,
				endAngle, false);
    }-*/;

    public final native void arcTo(double x1, double y1, double x2, double y2, double radius)
    /*-{
		this.arcTo(x1, y1, x2, y2, radius);
    }-*/;

    public final native void bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y)
    /*-{
		this.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
    }-*/;

    public final native void clearRect(double x, double y, double w, double h)
    /*-{
		this.clearRect(x, y, w, h);
    }-*/;

    public final native void clip()
    /*-{
		this.clip();
    }-*/;

    public final native void fill()
    /*-{
		this.fill();
    }-*/;

    public final native void stroke()
    /*-{
		this.stroke();
    }-*/;

    public final native void fillRect(double x, double y, double w, double h)
    /*-{
		this.fillRect(x, y, w, h);
    }-*/;

    public final native void fillText(String text, double x, double y)
    /*-{
		this.fillText(text, x, y);
    }-*/;

    public final native void fillTextWithGradient(String text, double x, double y, double sx, double sy, double ex, double ey, String color)
    /*-{
		var grad = this.createLinearGradient(sx, sy, ex, ey);

		grad.addColorStop(0, color);

		grad.addColorStop(1, color);

		this.fillStyle = grad;

		this.fillText(text, x, y);
    }-*/;

    public final native void fillText(String text, double x, double y, double maxWidth)
    /*-{
		this.fillText(text, x, y, maxWidth);
    }-*/;

    public final native void setFillColor(String fill)
    /*-{
		this.fillStyle = fill;
    }-*/;

    public final native void rect(double x, double y, double w, double h)
    /*-{
		this.rect(x, y, w, h);
    }-*/;

    public final native void rotate(double angle)
    /*-{
		this.rotate(angle);
    }-*/;

    public final native void scale(double sx, double sy)
    /*-{
		this.scale(sx, sy);
    }-*/;

    public final native void setStrokeColor(String color)
    /*-{
		this.strokeStyle = color;
    }-*/;

    public final native void setStrokeWidth(double width)
    /*-{
		this.lineWidth = width;
    }-*/;

    public final native void setImageSmoothingEnabled(boolean enabled)
    /*-{
		this.imageSmoothingEnabled = enabled;
    }-*/;

    public final native void setFillGradient(LinearGradientJSO grad)
    /*-{
		if (grad) {
			var that = this.createLinearGradient(grad.start.x, grad.start.y,
					grad.end.x, grad.end.y);

			var list = grad.colorStops;

			for (i = 0; i < list.length; i++) {
				that.addColorStop(list[i].stop, list[i].color);
			}
			this.fillStyle = that;
		} else {
			this.fillStyle = null;
		}
    }-*/;

    public final native void setFillGradient(PatternGradientJSO grad)
    /*-{
		if (grad) {
			this.fillStyle = this.createPattern(grad.image(), grad.repeat);
		} else {
			this.fillStyle = null;
		}
    }-*/;

    public final native void setFillGradient(RadialGradientJSO grad)
    /*-{
		if (grad) {
			var that = this.createRadialGradient(grad.start.x, grad.start.y,
					grad.start.radius, grad.end.x, grad.end.y, grad.end.radius);

			var list = grad.colorStops;

			for (i = 0; i < list.length; i++) {
				that.addColorStop(list[i].stop, list[i].color);
			}
			this.fillStyle = that;
		} else {
			this.fillStyle = null;
		}
    }-*/;

    public final native void transform(TransformJSO jso)
    /*-{
		if (jso) {
			this.transform(jso[0], jso[1], jso[2], jso[3], jso[4], jso[5]);
		}
    }-*/;

    public final native void transform(double d0, double d1, double d2, double d3, double d4, double d5)
    /*-{
		this.transform(d0, d1, d2, d3, d4, d5);
    }-*/;

    public final native void setTransform(TransformJSO jso)
    /*-{
		if (jso) {
			this.setTransform(jso[0], jso[1], jso[2], jso[3], jso[4], jso[5]);
		}
    }-*/;

    public final native void setTransform(double d0, double d1, double d2, double d3, double d4, double d5)
    /*-{
		this.setTransform(d0, d1, d2, d3, d4, d5);
    }-*/;

    public final native void setToIdentityTransform()
    /*-{
		this.setTransform(1, 0, 0, 1, 0, 0);
    }-*/;

    public final native void setTextFont(String font)
    /*-{
		this.font = font;
    }-*/;

    public final native void setTextBaseline(String baseline)
    /*-{
		this.textBaseline = baseline || "alphabetic";
    }-*/;

    public final native void setTextAlign(String align)
    /*-{
		this.textAlign = align || "start";
    }-*/;

    public final native void strokeText(String text, double x, double y)
    /*-{
		this.strokeText(text, x, y);
    }-*/;

    public final native void setGlobalAlpha(double alpha)
    /*-{
		this.globalAlpha = alpha;
    }-*/;

    public final native void translate(double x, double y)
    /*-{
		this.translate(x, y);
    }-*/;

    public final native void setShadow(ShadowJSO shadow)
    /*-{
		if (shadow) {
			this.shadowColor = shadow.color;
			this.shadowOffsetX = shadow.offset.x;
			this.shadowOffsetY = shadow.offset.y;
			this.shadowBlur = shadow.blur;
		} else {
			this.shadowColor = "transparent";
			this.shadowOffsetX = 0;
			this.shadowOffsetY = 0;
			this.shadowBlur = 0;
		}
    }-*/;

    public final native boolean isSupported(String feature)
    /*-{
		return (this[feature] !== undefined);
    }-*/;

    public final native boolean isPointInPath(double x, double y)
    /*-{
		return this.isPointInPath(x, y);
    }-*/;

    public final native ImageData getImageData(double x, double y, double width, double height)
    /*-{
		return this.getImageData(x, y, width, height);
    }-*/;

    public final native ImageData createImageData(double width, double height)
    /*-{
		return this.createImageData(width, height);
    }-*/;

    public final native ImageData createImageData(ImageData data)
    /*-{
		return this.createImageData(data);
    }-*/;

    public final native void putImageData(ImageData imageData, double x, double y)
    /*-{
		this.putImageData(imageData, x, y);
    }-*/;

    public final native void putImageData(ImageData imageData, double x, double y, double dirtyX, double dirtyY, double dirtyWidth, double dirtyHeight)
    /*-{
		this.putImageData(imageData, x, y, dirtyX, dirtyY, dirtyWidth,
				dirtyHeight);
    }-*/;

    /**
     * Returns the metrics for the given text.
     *
     * @param text the text to measure, as a String
     * @return a {@link TextMetrics} object
     */
    public final native TextMetrics measureText(String text)
    /*-{
		return this.measureText(text);
    }-*/;

    public final native void drawImage(Element image, double x, double y)
    /*-{
		this.drawImage(image, x, y);
    }-*/;

    public final native void drawImage(Element image, double x, double y, double w, double h)
    /*-{
		this.drawImage(image, x, y, w, h);
    }-*/;

    public final native void drawImage(Element image, double sx, double sy, double sw, double sh, double x, double y, double w, double h)
    /*-{
		this.drawImage(image, sx, sy, sw, sh, x, y, w, h);
    }-*/;

    public final native void resetClip()
    /*-{
		this.resetClip();
    }-*/;

    public final native void setMiterLimit(double limit)
    /*-{
		this.miterLimit = limit;
    }-*/;

    public final native void setLineDash(NFastDoubleArrayJSO dashes)
    /*-{
		if (this.LienzoSetLineDash) {
			this.LienzoSetLineDash(dashes || []);
		}
    }-*/;

    public final native void setLineDashOffset(double offset)
    /*-{
		if (this.LienzoSetLineDashOffset) {
			this.LienzoSetLineDashOffset(offset);
		}
    }-*/;

    public final native double getBackingStorePixelRatio()
    /*-{
		return this.LienzoBackingStorePixelRatio || 1;
    }-*/;

    public final native boolean path(PathPartListJSO list)
    /*-{
		if (!list) {
			return false;
		}
		var leng = list.length;
		if (leng < 1) {
			return false;
		}
		var indx = 0;
		var fill = false;
		this.beginPath();
		while (indx < leng) {
			var e = list[indx++];
			var p = e.points;
			switch (e.command) {
			case 1:
				this.lineTo(p[0], p[1]);
				break;
			case 2:
				this.moveTo(p[0], p[1]);
				break;
			case 3:
				this.bezierCurveTo(p[0], p[1], p[2], p[3], p[4], p[5]);
				break;
			case 4:
				this.quadraticCurveTo(p[0], p[1], p[2], p[3]);
				break;
			case 5:
				this.LienzoEllipse(p[0], p[1], p[2], p[3], p[6], p[4], p[4]
						+ p[5], (1 - p[7]) > 0);
				break;
			case 6:
				this.closePath();
				fill = true;
				break;
			case 7:
				this.arcTo(p[0], p[1], p[2], p[3], p[4]);
				break;
			}
		}
		return fill;
    }-*/;

    public final native boolean clip(PathPartListJSO list)
    /*-{
		if (!list) {
			return false;
		}
		var leng = list.length;
		if (leng < 1) {
			return false;
		}
		var indx = 0;
		var fill = false;
		while (indx < leng) {
			var e = list[indx++];
			var p = e.points;
			switch (e.command) {
			case 1:
				this.lineTo(p[0], p[1]);
				break;
			case 2:
				this.moveTo(p[0], p[1]);
				break;
			case 3:
				this.bezierCurveTo(p[0], p[1], p[2], p[3], p[4], p[5]);
				break;
			case 4:
				this.quadraticCurveTo(p[0], p[1], p[2], p[3]);
				break;
			case 5:
				this.LienzoEllipse(p[0], p[1], p[2], p[3], p[6], p[4], p[4]
						+ p[5], (1 - p[7]) > 0);
				break;
			case 6:
				return true;
				break;
			case 7:
				this.arcTo(p[0], p[1], p[2], p[3], p[4]);
				break;
			}
		}
		return fill;
    }-*/;

    public final native void fill(NativePath2D path)
    /*-{
		if (path) {
			this.fill(path);
		}
    }-*/;

    public final native void stroke(NativePath2D path)
    /*-{
		if (path) {
			this.stroke(path);
		}
    }-*/;

    public final native void clip(NativePath2D path)
    /*-{
		if (path) {
			this.clip(path);
		}
    }-*/;

    public final native NativePath2D getCurrentPath()
    /*-{
		return this.currentPath || null;
    }-*/;

    public final native void setCurrentPath(NativePath2D path)
    /*-{
		if (path) {
			this.currentPath = path;
		}
    }-*/;
}