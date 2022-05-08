package org.rebelalliance.flightplanner.repository;

import org.rebelalliance.flightplanner.model.TripEntity;
import org.rebelalliance.flightplanner.repositories.TripRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@TestConfiguration
public class RepositoryContextConfiguration {
    @Bean
    public TripRepository tripRepository() {
        return new TripRepository() {
            @Override
            public List<TripEntity> findAll() {
                return null;
            }

            @Override
            public List<TripEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<TripEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<TripEntity> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(TripEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends TripEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends TripEntity> S save(S entity) {
                return null;
            }

            @Override
            public <S extends TripEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<TripEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends TripEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends TripEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<TripEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public TripEntity getOne(Long aLong) {
                return null;
            }

            @Override
            public TripEntity getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends TripEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends TripEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends TripEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends TripEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends TripEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends TripEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends TripEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public TripEntity findOneByUuid(UUID uuid) {
                return null;
            }

            @Override
            public TripEntity saveAll(TripEntity params) {
                return null;
            }

            @Override
            public void deleteOneByUuid(UUID uuid) {

            }
        };
    }
}
