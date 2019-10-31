package com.josue;
import java.io.*;
import java.util.*;

public class DocumentManagamentSystem {

	public static class Heading {
		protected int weight;
		protected String text;

		public Heading(int weight, String text) {
			this.weight = weight;
			this.text = text;
		}
	}
	public static class Node {
		protected Heading heading;
		protected List<Node> children;

		public Node(Heading heading) {
			this.heading = heading;
			this.children = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Heading> headings = new ArrayList<>();
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			if ("".equals(line))
				break;
			headings.add(parse(line));
		}
		Node outline = toOutline(headings);
		String html = toHtml(outline);
		System.out.println(html);
	}

	/////////// BEGIN EDITABLE //////////////
	private static Node toOutline(List<Heading> headings) {
		Node root = new Node(new Heading(0,""));
		if (headings.size() > 1) {
			return addNode(headings.get(0),root, 0, headings);
		}else {
			root.children.add(new Node(headings.get(0)));
			return root;
		}
	}
	
	private static Node addNode(Heading heading, Node node, int pos, List<Heading> headings) {
		if (node.heading.weight < heading.weight && pos < headings.size()) {
			Node nodoH = new Node(heading);
			node.children.add(nodoH);
			return addNode(headings.get(pos), node, ++pos, headings);
		} else {
			node.children.add(new Node(heading));
			return node;
		}
	}
	
	/////////// END EDITABLE //////////////


	/** Parses a line of input.
    This implementation is correct for all predefined test cases. */
	private static Heading parse(String record) {
		String[] parts = record.split(" ", 2);
		int weight = Integer.parseInt(parts[0].substring(1));
		Heading heading = new Heading(weight, parts[1].trim());
		return heading;
	}

	/** Converts a node to HTML.
    This implementation is correct for all predefined test cases. */
	private static String toHtml(Node node) {
		StringBuilder buf = new StringBuilder();
		if (!node.heading.text.isEmpty()) {
			buf.append(node.heading.text);
			buf.append("\n");
		}
		Iterator<Node> iter = node.children.iterator();
		if (iter.hasNext()) {
			buf.append("<ul>");

			while (iter.hasNext()) {
				Node child = iter.next();
				buf.append("<li>");
				buf.append(toHtml(child));
				buf.append("</li>");
				if (iter.hasNext()) {
					buf.append("\n");
				}
			}
			buf.append("</ul>");
		}
		return buf.toString();
	}
}


