package com.sdd.restapiswagger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "m_mahasiswa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class mMahasiswa {
    @Id
    @SequenceGenerator(name = "MMAHASISWA_MAHASISWAPK_GENERATOR", sequenceName="MMAHASISWA_SEQ", allocationSize=1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MMAHASISWA_MAHASISWAPK_GENERATOR")
    @Column(name = "id", unique=true, nullable = false)
    private String id;
    @Column(name = "npm", nullable = false, length = 64)
    private String npm;
    @Column(name = "nama_mahasiswa", nullable = false, length = 64)
    private String namaMahasiswa;
    @Column(name = "email", nullable = false, length = 64)
    private String email;
    @Column(name = "alamat", nullable = false, length = 64)
    private String alamat;
    @Column(name = "jk", nullable = false, length = 64)
    private String jenisKelamin;
    private Boolean isActive;
    @Column(name = "created_date", nullable = false, length = 64)
    private String createdDate;
}
