-- DDL (Data Definition Language) di atas adalah perintah SQL untuk membuat tabel contact dengan struktur kolom sebagai berikut:
-- Kolom
-- id: Kolom primary key dengan tipe data VARCHAR(36), yang berarti dapat menyimpan string dengan panjang maksimum 36 karakter.
-- name: Kolom dengan tipe data VARCHAR(50) yang tidak boleh kosong (NOT NULL), yang berarti harus diisi dengan nilai string dengan panjang maksimum 50 karakter.
-- phone_number: Kolom dengan tipe data VARCHAR(20) yang tidak boleh kosong (NOT NULL), yang berarti harus diisi dengan nilai string dengan panjang maksimum 20 karakter.
-- email: Kolom dengan tipe data VARCHAR(100) yang boleh kosong, yang berarti dapat diisi dengan nilai string dengan panjang maksimum 100 karakter.
-- address: Kolom dengan tipe data TEXT yang boleh kosong, yang berarti dapat diisi dengan nilai teks dengan panjang tidak terbatas.
-- notes: Kolom dengan tipe data TEXT yang boleh kosong, yang berarti dapat diisi dengan nilai teks dengan panjang tidak terbatas.
-- created_at: Kolom dengan tipe data DATETIME yang boleh kosong, yang berarti dapat diisi dengan nilai tanggal dan waktu.
-- updated_at: Kolom dengan tipe data DATETIME yang boleh kosong, yang berarti dapat diisi dengan nilai tanggal dan waktu.

CREATE TABLE contact (
	id VARCHAR(36) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	email VARCHAR(100),
	address TEXT,
	notes TEXT,
	created_at DATETIME,
	updated_at DATETIME
);

-- Keterangan
-- Kolom id digunakan sebagai primary key, yang berarti setiap nilai pada kolom ini harus unik dan tidak boleh kosong.
-- Kolom name dan phone_number tidak boleh kosong, yang berarti harus diisi dengan nilai yang valid.
-- Kolom email, address, notes, created_at, dan updated_at boleh kosong, yang berarti dapat diisi dengan nilai yang valid atau kosong.