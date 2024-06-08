package roomescape.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import roomescape.service.dto.request.CreateReservationRequest;

import java.time.LocalDate;

public record WaitingRequest(
        @NotNull(message = "날짜를 입력해주세요.")
        LocalDate date,

        @NotNull(message = "예약 시간 id을 입력해주세요.")
        @Positive
        Long timeId,

        @NotNull(message = "테마 id을 입력해주세요.")
        @Positive
        Long themeId
) {
    public CreateReservationRequest toCreateReservationRequest(long memberId) {
        return new CreateReservationRequest(date, timeId, themeId, memberId);
    }
}
