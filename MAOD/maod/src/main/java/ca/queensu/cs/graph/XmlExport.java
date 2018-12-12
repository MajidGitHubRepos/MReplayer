package ca.queensu.cs.graph;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import com.mxpdf.text.Document;
import com.mxpdf.text.Rectangle;
import com.mxpdf.text.pdf.PdfContentByte;
import com.mxpdf.text.pdf.PdfWriter;
import com.mxgraph.canvas.mxGraphics2DCanvas;
import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.io.mxCodec;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.util.png.mxPngEncodeParam;
import com.mxgraph.util.png.mxPngImageEncoder;
import com.mxgraph.util.mxCellRenderer.CanvasFactory;
import com.mxgraph.view.mxGraph;

// This example requires iText from http://www.lowagie.com/iText/
public class XmlExport
{
	public XmlExport() throws Exception
	{
		// Creates graph with model
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			mxCell v2 = (mxCell) graph.insertVertex(parent, null, "World!",
					240, 150, 80, 30);
			graph.insertEdge(parent, null, "e1", v1, v2);
		}
		finally
		{
			graph.getModel().endUpdate();
		}
		
		
			    org.w3c.dom.Document document = mxXmlUtils.parseXml(mxUtils.readFile("ff"));

		
	

//		mxRectangle bounds = graph.getGraphBounds();
//		Document document = new Document(new Rectangle((float) (bounds
//				.getWidth()), (float) (bounds.getHeight())));
//		PdfWriter writer = PdfWriter.getInstance(document,
//				new FileOutputStream("example.pdf"));
//		document.open();
//		final PdfContentByte cb = writer.getDirectContent();
//
//		mxGraphics2DCanvas canvas = (mxGraphics2DCanvas) mxCellRenderer
//				.drawCells(graph, null, 1, null, new CanvasFactory()
//				{
//					public mxICanvas createCanvas(int width, int height)
//					{
//						Graphics2D g2 = cb.createGraphics(width, height);
//						return new mxGraphics2DCanvas(g2);
//					}
//				});
//
//		canvas.getGraphics().dispose();
//		document.close();
	}

	public static void main(String[] args)
	{
		try
		{
			new XmlExport();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}