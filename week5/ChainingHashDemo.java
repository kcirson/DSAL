package week5;

import java.util.LinkedList;
import java.util.Random;

public class ChainingHashDemo<E> implements ChainingHashInterface<E> {
	LinkedList<E>[] table_;
	int len_ = 4;

	@SuppressWarnings("unchecked")
	public ChainingHashDemo() {
		table_ = (LinkedList<E>[]) new LinkedList[len_];

		for (int i = 0; i < table_.length; i++)
			table_[i] = new LinkedList<E>();
	}

	@Override
	public boolean search(E e) {
		LinkedList<E> bit = table_[e.hashCode() % len_];

		return bit.contains(e);
	}

	@Override
	public boolean insert(E e) {
		int vul_ = 0;
		boolean has = search(e);
		Double len = len_ * 1.0;

		for (int i = 0; i < len_; i++)
			if (!table_[i].equals(new LinkedList<E>()))
				vul_ += 1;

		if (vul_ / len >= 0.75)
			rehash(len_ * 2);

		if (!has)
			table_[e.hashCode() % len_].add(e);

		return !has;
	}

	@SuppressWarnings("unchecked")
	private void rehash(int newLen) {
		LinkedList<E>[] newtable = new LinkedList[newLen];

		for (int i = 0; i < newtable.length; i++) {
			newtable[i] = new LinkedList<E>();
		}

		for (int i = 0; i < len_; i++) {
			LinkedList<E> el = table_[i];
			if (!el.equals(new LinkedList<E>()))
				newtable[el.get(0).hashCode() % newLen] = table_[el.get(0).hashCode() % len_];
		}

		table_ = newtable;
		len_ = newLen;
		System.out.println(this.toString());
	}

	public String toString() {
		String output = "";

		output += "Tabel lengte = " + len_ + ": \n";

		for (int i = 0; i < len_; i++) {
			if (!table_[i].equals(new LinkedList<E>())) {
				output += i + ": " + table_[i].toString() + "\n";
			}
		}

		return output;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		ChainingHashDemo<Integer> chd = new ChainingHashDemo<Integer>();

		for (int i = 0; i < 200; i++) {
			chd.insert(new Integer(rand.nextInt(1000)));
		}
	}
}